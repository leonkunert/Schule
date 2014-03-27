SELECT
	name, fahrtzeit
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
    `haltestelle-linie-mapping`.linie_id = (
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
			haltestelle.id = 12
    );