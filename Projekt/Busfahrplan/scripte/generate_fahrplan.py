linien = 5
wochentage = 7
fa = 1
bu = 1
f = open('sql.sql', 'w')
f.write('INSERT INTO kurs (bus, fahrer, linie, wochentag, schicht, tour) VALUES \r\n')

for d in range(0, wochentage):
	for l in range(0, linien):
		for tour in range(1,3):
			for schicht in range(1,3):
				f.write("({0}, {1}, {2}, {3}, {4}, {5}),\r\n".format(bu, fa, l+1, d, schicht, tour))
				print "({0}, {1}, {2}, {3}, {4}, {5}),".format(bu, fa, l+1, d, schicht, tour)
				if fa == 30:
					fa = 1
				else:
					fa += 1
			if bu == 12:
				bu = 1
			else:
				bu += 1

f.close()
