
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Bernd");
		Person p2 = new Person("Bernd2");
		Termin t1 = new Termin("Java t�ten", p);
		Termin t2 = new Termin("Java nochmal t�ten", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		new Termin("und nochmal", p);
		
		t1.addTeilnehmer(p2);
		t2.addTeilnehmer(p2);
		p2.uebersicht();
		p.uebersicht();
		
	}

}
