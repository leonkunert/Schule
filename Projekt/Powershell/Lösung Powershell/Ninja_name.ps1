# Nach altem Namen fragen
$name = Read-Host 'Anwärter wie lautet dein Name?'
$result = ""
$i = 0
while($i -lt $name.length){
    if ($name.Substring($i,1) -like "a") {
        $result += "ka"
    }
    if ($name.Substring($i,1) -like "b") {
        $result += "zu"
    }
    if ($name.Substring($i,1) -like "c") {
        $result += "mi"
    }
    if ($name.Substring($i,1) -like "d") {
        $result += "te"
    }
    if ($name.Substring($i,1) -like "e") {
        $result += "ku"
    }
    if ($name.Substring($i,1) -like "f") {
        $result += "lu"
    }
    if ($name.Substring($i,1) -like "g") {
        $result += "ji"
    }
    if ($name.Substring($i,1) -like "h") {
        $result += "ri"
    }
    if ($name.Substring($i,1) -like "i") {
        $result += "ki"
    }
    if ($name.Substring($i,1) -like "j") {
        $result += "zu"
    }
    if ($name.Substring($i,1) -like "k") {
        $result += "me"
    }
    if ($name.Substring($i,1) -like "l") {
        $result += "ta"
    }
    if ($name.Substring($i,1) -like "m") {
        $result += "rin"
    }
    if ($name.Substring($i,1) -like "n") {
        $result += "to"
    }
    if ($name.Substring($i,1) -like "o") {
        $result += "mo"
    }
    if ($name.Substring($i,1) -like "p") {
        $result += "no"
    }
    if ($name.Substring($i,1) -like "q") {
        $result += "ke"
    }
    if ($name.Substring($i,1) -like "r") {
        $result += "shi"
    }
    if ($name.Substring($i,1) -like "s") {
        $result += "ari"
    }
    if ($name.Substring($i,1) -like "t") {
        $result += "chi"
    }
    if ($name.Substring($i,1) -like "u") {
        $result += "do"
    }
    if ($name.Substring($i,1) -like "v") {
        $result += "ru"
    }
    if ($name.Substring($i,1) -like "w") {
        $result += "mei"
    }
    if ($name.Substring($i,1) -like "x") {
        $result += "na"
    }
    if ($name.Substring($i,1) -like "y") {
        $result += "fu"
    }
    if ($name.Substring($i,1) -like "z") {
        $result += "zi"
    }
    if ($name.Substring($i,1) -like " ") {
        $result += " "
    }
    $i++
}
echo "Hallo "$name" ab heute heißt du "$result