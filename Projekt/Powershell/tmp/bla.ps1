
cls
$con = "Server=localhost;Uid=root;database=ad"
[void][system.reflection.Assembly]::LoadFrom("C:\MySql.Data.dll")
$dbcon = New-Object MySql.Data.MySqlClient.MySqlConnection
$dbcon.ConnectionString = $con
$dbcon.Open()
#echo $dbcon
$cmd = New-Object MySql.Data.MySqlClient.MySqlCommand
$cmd.Connection = $dbcon

$cmd.CommandText = "SELECT * FROM benutzer"

$reader = $cmd.ExecuteReader()