SELECT stunde, minute
FROM `busfahrplan`.`fahrplan`
where haltestelle_id = 12 
and linie_id = 2 
and wochentag = weekday(now());