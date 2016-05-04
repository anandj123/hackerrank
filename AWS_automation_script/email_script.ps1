param (
    [string]$subject = "testing mail",
    [string]$body = "Error during Business Panorama script execution"
 )
 
#senders network id
$CredUser = "*****"
#senders network password
$CredPassword ="********"

$EmailFrom = “ajain58@its.jnj.com”
$EmailTo = “ajain58@its.jnj.com”
$Subject = $subject
$Body = $body
$SMTPServer = “smtp.na.jnj.com”
$SMTPClient = New-Object Net.Mail.SmtpClient($SmtpServer, 25)
$SMTPClient.EnableSsl = $true
$SMTPClient.Credentials = New-Object System.Net.NetworkCredential($CredUser, $CredPassword);
[System.Net.ServicePointManager]::ServerCertificateValidationCallback = { return $true }
$SMTPClient.Send($EmailFrom, $EmailTo, $Subject, $Body)