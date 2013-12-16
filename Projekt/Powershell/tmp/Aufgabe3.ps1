Import-Module ActiveDirectory
cls

[void][system.reflection.Assembly]::LoadFrom("C:\MySql.Data.dll")

$conn = New-Object MySql.Data.MySqlClient.MySqlConnection("Server=localhost; Database=ad; Uid=root")

$conn.Open()

#echo $conn

#Alle User der Datenbank aus dem AD entfernen

$objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand("SELECT * FROM benutzer", $conn)

#echo $objCommand

$reader = $objCommand.ExecuteReader()
while($reader.Read) {

    echo $reader.GetValue(0)
}
return

#echo "bla"

$objDataAdapter = New-Object MySql.Data.MySqlClient.MySqlDataAdapter($objCommand)

#echo $objDataAdapter

$objDataSet = New-Object System.Data.DataSet

$res = $objDataAdapter.Fill($objDataSet, "hgak")

echo $res

#echo $objDataAdapter
$Ergebnis = $objDataSet.Tables[0]
$Ergebnis | Format-Table *