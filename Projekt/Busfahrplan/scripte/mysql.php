<?php
$link = mysql_connect('localhost', 'root', '');

if (!$link) {
    die('Verbindung schlug fehl: ' . mysql_error());
}
//echo 'Erfolgreich verbunden';

mysql_query('USE busfahrplan', $link);

$haltestellen_anz = 42;

for($num = 1; $num <= $haltestellen_anz; $num++) {
	$haltestellen = ArrAy();
	echo('INSERT INTO fahrplan(wochentag, stunde, minute, haltestelle_id, linie_id) VALUES ');
	$res = mysql_query('
	SELECT
		*
	FROM
		`haltestelle`
	CROSS JOIN
		`haltestelle-linie-mapping` 
	ON
		`haltestelle-linie-mapping`.haltestelle_id = haltestelle.id
	CROSS JOIN
		`einsatzzeit-linie-mapping`
	ON
		`einsatzzeit-linie-mapping`.linie_id = `haltestelle-linie-mapping`.linie_id
	CROSS JOIN
		`einsatzzeit`
	ON
		`einsatzzeit`.id = `einsatzzeit-linie-mapping`.einsatzzeit_id
		  
		WHERE
		# Alle Haltestellen der Linie holen
		`haltestelle-linie-mapping`.linie_id IN (
			SELECT
				`linie_id`
			FROM
				haltestelle
			# Verbindung zur Linie herstellen
			CROSS JOIN 
				`haltestelle-linie-mapping` 
			ON
				`haltestelle-linie-mapping`.haltestelle_id = haltestelle.id
			WHERE
				haltestelle.id = '.$num.'
		)
		AND haltestelle.id = '.$num.';
	', $link);

	while ($data = mysql_fetch_object($res)) {
		$haltestellen[] = array(
			'haltestelle_id' => $data->haltestelle_id,
			'linie_id'       => $data->linie_id,
			'fahrtzeit'       => $data->fahrtzeit,
			'haltestellennummer' => $data->haltestellennummer,
			'von_wochentag' => $data->von_wochentag,
			'bis_wochentag' => $data->bis_wochentag,
			'von_uhrzeit'  => $data->von_uhrzeit,
			'bis_uhrzeit' => $data->bis_uhrzeit,
			'takt' => $data->takt
		);
	}

	foreach ($haltestellen as $haltestelle) {
		for ($i = $haltestelle['von_wochentag']; $i <= $haltestelle['bis_wochentag']; $i++) {
			for ($j = $haltestelle['von_uhrzeit']; $j <= $haltestelle['bis_uhrzeit']; $j = $j + ($haltestelle['takt']/60)) {
				$uhrzeit = strtotime('today '.convertTime($j).' + '.$haltestelle['fahrtzeit'].'minutes');
				//echo '!<pre>';
				//var_dump($num);
				//var_dump($haltestelle['haltestelle_id']);
				//echo '!';
				echo (' ('.$i.','.date('H', $uhrzeit).','.date('i', $uhrzeit).','.$haltestelle['haltestelle_id'].', '.$haltestelle['linie_id'].'),');
			}
		}
	}
	echo ';';
}

function convertTime($dec)
{
	// start by converting to seconds
	$seconds = (int)($dec * 3600);
	// we're given hours, so let's get those the easy way
	$hours = floor($dec);
	// since we've "calculated" hours, let's remove them from the seconds variable
	$seconds -= $hours * 3600;
	// calculate minutes left
	$minutes = floor($seconds / 60);
	// remove those from seconds as well
	$seconds -= $minutes * 60;
	// return the time formatted HH:MM:SS
	return lz($hours).":".lz($minutes).":".lz($seconds);
}

// lz = leading zero
function lz($num)
{
    return (strlen($num) < 2) ? "0{$num}" : $num;
}

mysql_close($link);
?>