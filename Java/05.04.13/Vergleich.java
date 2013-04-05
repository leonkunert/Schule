public class Vergleich{

	public static void main(String[] args) {
		//Zwei Random Zahlen zwischen 10 und 70
		int zahl1 = (int)(Math.random()*(70-10)+10);
		int zahl2 = (int)(Math.random()*(70-10)+10);
		if(zahl2 == zahl1){
			System.out.println("Zahlen sind gleich");
		}else{//Zahlen nicht gleich
			System.out.println("Zahlen sind nicht gleich");
			if(zahl1>zahl2){//zahl1>zahl2
				System.out.println(zahl1+" ist größer als "+ zahl2);
			}else{//zahl1<zahl2
				System.out.println(zahl1+" ist kleiner als "+zahl2);
			}
		}
	}
}