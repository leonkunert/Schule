
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Zentrale z = new Zentrale();
		Supermarkt s = new Supermarkt("SuperSupermarktSuper",z);
		Kasse k	= new Kasse("Kasse1",s);
			
		//TagesEinnahmen berechnen f�r Kassen
		k.setKassenstand(3.5);
		k.setEinlage(1.7);
		System.out.println(
			k.tageinges()
		);
		
		//TagesEinnahen berechnen f�r Supermarkt
		
		System.out.println(
			s.tageinges()
		);
		
	}

}
