SELECT 
            kurs.id AS 'Einsatz',
            bus.nummer AS 'Busnummer',
            busfahrer.name AS 'Busfahrer',
            linie.name AS 'Linie',
            haltestelle.name AS 'Starthaltestelle',
            kurs.schicht as 'Schicht',
            kurs.tour as 'Tour',
            concat(floor(einsatzzeit.von_uhrzeit-(linie.einsetzfahrt/60))+(kurs.schicht-1)*9+(kurs.tour-1), ':', 60-linie.einsetzfahrt) as 'Dienstbegin',
            concat(floor(einsatzzeit.von_uhrzeit-(linie.einsetzfahrt/60))+(kurs.schicht)*9, ':', 60-linie.einsetzfahrt) as 'Feierabend',
            a.Date AS 'Einsatzdatum'
    FROM
        kurs CROSS JOIN bus
            ON bus.id = kurs.bus
        CROSS JOIN busfahrer
            ON busfahrer.id = kurs.fahrer
        CROSS JOIN linie
            ON linie.id = kurs.linie
        CROSS JOIN ( SELECT   
             '2030-01-01' - INTERVAL  (a.a + (10 * b.a) + (100 * c.a) + (1000 * d.a)) DAY AS Date 
         FROM 
             ( SELECT   
                 0 AS a UNION  ALL SELECT 
                     1 UNION  ALL SELECT 
                     2 UNION  ALL SELECT 
                     3 UNION  ALL SELECT 
                     4 UNION  ALL SELECT 
                     5 UNION  ALL SELECT 
                     6 UNION  ALL SELECT 
                     7 UNION  ALL SELECT 
                     8 UNION  ALL SELECT 
                     9 ) AS a CROSS JOIN ( SELECT   
                 0 AS a UNION  ALL SELECT 
                     1 UNION  ALL SELECT 
                     2 UNION  ALL SELECT 
                     3 UNION  ALL SELECT 
                     4 UNION  ALL SELECT 
                     5 UNION  ALL SELECT 
                     6 UNION  ALL SELECT 
                     7 UNION  ALL SELECT 
                     8 UNION  ALL SELECT 
                     9 ) AS b
            CROSS JOIN ( SELECT   
                 0 AS a UNION  ALL SELECT 
                     1 UNION  ALL SELECT 
                     2 UNION  ALL SELECT 
                     3 UNION  ALL SELECT 
                     4 UNION  ALL SELECT 
                     5 UNION  ALL SELECT 
                     6 UNION  ALL SELECT 
                     7 UNION  ALL SELECT 
                     8 UNION  ALL SELECT 
                     9 ) AS c
            CROSS JOIN ( SELECT   
                 0 AS a UNION  ALL SELECT 
                     1 UNION  ALL SELECT 
                     2 UNION  ALL SELECT 
                     3 UNION  ALL SELECT 
                     4 UNION  ALL SELECT 
                     5 UNION  ALL SELECT 
                     6 UNION  ALL SELECT 
                     7 UNION  ALL SELECT 
                     8 UNION  ALL SELECT 
                     9 ) AS d ) a
            ON 
            weekday(a.Date) = kurs.wochentag
        cross join `einsatzzeit-linie-mapping`
            on `einsatzzeit-linie-mapping`.linie_id = linie.id
        cross join einsatzzeit
            on einsatzzeit.id = `einsatzzeit-linie-mapping`.einsatzzeit_id
        cross join `haltestelle-linie-mapping`
            on `haltestelle-linie-mapping`.linie_id = linie.id
        cross join haltestelle
            on haltestelle.id = `haltestelle-linie-mapping`.haltestelle_id
    WHERE
        a.Date BETWEEN '2014-04-14' AND '2014-04-20' 
        and weekday(a.Date) between einsatzzeit . von_wochentag and einsatzzeit . bis_wochentag 
        and `haltestelle-linie-mapping`.haltestellennummer = 1
    ORDER BY
        a.Date ASC,(einsatzzeit.von_uhrzeit -(linie.einsetzfahrt / 60)) +(kurs.schicht - 1)* 9 +(kurs.tour - 1) ASC,Linie ASC;