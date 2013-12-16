#### Import des AD Moduls ####
Import-Module ActiveDirectory

Get-ADUser -Filter {name -like "*"}

$user.Benutzername = "*"

#Get-ADUser -Filter {name -like $user.Benutzername}