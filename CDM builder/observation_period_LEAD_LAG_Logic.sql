select enrolid,dtstart,ld_dtend
from 
   (select enrolid,  dtstart, LEAD(dtend) OVER ( PARTITION BY enrolid  ORDER BY dtstart) as ld_dtend,dtend,flag,MINDT_IND,row_num
    from 
      (SELECT enrolid, dtstart,dtend, flag, CASE WHEN flag != lag(flag) over (PARTITION BY enrolid ORDER BY enrolid,dtstart) THEN 1 ELSE 0 END as MINDT_IND ,row_num
       from 
         (select enrolid, dtstart, dtend, case when to_date(nvl(LEAD(dtstart) OVER ( PARTITION BY enrolid  ORDER BY dtstart),dateadd(day,33,dtend)),'yyyy-mm-dd') - dtend > 32 then 'Y' else 'N' end  as flag, ROW_NUMBER() OVER (PARTITION BY enrolid ORDER BY dtstart) AS row_num
          from native.enrollment_detail_tmp
         )  
      ) 
    where MINDT_IND = 1 or row_num = 1 
   )
where flag !='Y'


