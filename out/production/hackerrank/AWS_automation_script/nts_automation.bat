@echo off

set INIFILE=".\nts.ini"
set PROCESSING_STEP = ""
call :getvalue %INIFILE% "local_input" " " local_input
call :getvalue %INIFILE% "local_intermediate" " " local_intermediate
call :getvalue %INIFILE% "local_out" " " local_out
call :getvalue %INIFILE% "local_prog" " " local_prog
call :getvalue %INIFILE% "lock_dir" " " lock_dir
call :getvalue %INIFILE% "s3_in" " " s3_in
call :getvalue %INIFILE% "s3_arch" " " s3_arch
call :getvalue %INIFILE% "s3_out" " " s3_out
call :getvalue %INIFILE% "xls_script_dir" " " xls_script_dir
call :getvalue %INIFILE% "pig_script_dir" " " pig_script_dir
call :getvalue %INIFILE% "pig_output_dir" " " pig_output_dir

echo local_input: %local_input%
echo local_intermediate: %local_intermediate%
echo s3_out: %s3_out%
echo s3_in: %s3_in%

:: check the lock file
for /F %%i in ('dir /b %lock_dir%\*.*') do (
	::If lock file is present then exit as some other process is already running.
	echo ********* Some other process is already running, exiting..... ********* 
	goto :clean_up
)
echo ********* creating lock file ********* 
copy /y nul  %lock_dir%\cmdb.lock 

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Copy file from S3 to local. *********
echo %PROCESSING_STEP% 
aws s3 cp %s3_in% %local_input% --recursive --sse
IF NOT %ERRORLEVEL% == 0  goto :error_tag

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Converting XLS to CSV. *********
echo %PROCESSING_STEP% 
echo %xls_script_dir%\ntsxlscsvconv.wsf
%xls_script_dir%\ntsxlscsvconv.wsf
IF NOT %ERRORLEVEL% == 0  goto :error_tag

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Copy csv files to S3. *********
echo %PROCESSING_STEP% 
aws s3 cp  %local_out%  %s3_out% --recursive
IF NOT %ERRORLEVEL% == 0  goto :error_tag

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Archive S3 input files. *********
echo %PROCESSING_STEP% 
aws s3 mv  %s3_in%  %s3_arch% --recursive --sse 
IF NOT %ERRORLEVEL% == 0  goto :error_tag

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Cleanup local files. *********
echo %PROCESSING_STEP% 
del %local_out%\*.* /F /Q
del %local_in%\*.*  /F /Q
IF NOT %ERRORLEVEL% == 0  goto :error_tag

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* EMR Dimension Data Cleansing. *********
echo %PROCESSING_STEP% 
aws emr  add-steps --cluster-id XXXXXX KeyName=XXXXXX --steps Type=PIG,Name="Panorama extract",ActionOnFailure=CONTINUE,Args=[-f,s3://xxxx/yyyyy.pig,-p,file=s3://xxxxx/out/yyyy.csv,-p,out1=s3://xxxxx,-p,out2=s3://xxxx,-p,key=0,-p,keyCol=Brand] >emr_submit.out
IF NOT %ERRORLEVEL% == 0  goto :error_tag

:repeat_emr_job_status_check
aws emr list-steps --cluster-id xxxx >emr_status.out
call :get_emr_job_status
::wait 10 seconds before checking the status again.
@ping 127.0.0.1 -n 2 -w 10000 > nul
if %emr_job_status%==PENDING goto :repeat_emr_job_status_check
if %emr_job_status%==RUNNING goto :repeat_emr_job_status_check
if NOT %emr_job_status%==COMPLETED goto :error_tag 

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Load Redshift tables *********
echo %PROCESSING_STEP% 
set PGPASSWORD=G3k1-t2RNAIc
set PGCLIENTENCODING=UTF8
psql -w --host="x.x.x.x" --username=xxxx --dbname=xxx --port=5439 -c "copy xxxx from 's3://xxxx/yyyy.csv' CREDENTIALS 'aws_access_key_id=xxxx;aws_secret_access_key=yyyy' delimiter ',' removequotes" 
IF NOT %ERRORLEVEL% == 0  goto :error_tag
GOTO :clean_up 

::---------------------------------------------------------------------------------------------
set PROCESSING_STEP=********* Insert audit record for successful completion *********
echo %PROCESSING_STEP% 
psql -w --host="xx.xx.xx.xx" --username=xx --dbname=xx --port=5439 -c "select * from xxxx" 
IF NOT %ERRORLEVEL% == 0  goto :error_tag

:error_tag
echo ERROR HAPPENED DURING - %PROCESSING_STEP%
powershell -ExecutionPolicy Bypass -File "email_script.ps1" -body %PROCESSING_STEP%

:clean_up
del %lock_dir%\*.* /F /Q

echo ********* All done... *********
goto :eof

:getvalue
:: This function reads a value from an INI file and stored it in a variable
:: %1 = name of ini file to search in.
:: %2 = search term to look for
:: %3 = group name (not currently used)
:: %4 = variable to place search result
FOR /F "eol=; eol=[tokens=1,2* delims==" %%i in ('FINDSTR /b /l /i %~2= %1') DO set %~4=%%~j
goto :eof

:get_emr_job_status
for /f "tokens=1,2" %%l in (emr_submit.out) do (set jobid=%%m)

for /f "tokens=1,2,3" %%l in (emr_status.out) do (	if %%n==%jobid% goto :foundJob )

:foundJob
for /f "tokens=1,2" %%i in (emr_status.out) do (
    set emr_job_status=%%j
	if %%i == STATUS GOTO :gotstatus
)

:gotstatus
echo jobid : %jobid% status: %emr_job_status%
goto :eof
