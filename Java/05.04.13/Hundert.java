public class Hundert{
	public static void main(String[] args) {
		int max = 0;
		int min = 97;
		int zahl = 0;
		for(int i = 0; i<=100; i++){//Hundert Zufallszahlen anlegen
			zahl = (int)(Math.random()*(96-34)+34);
			if(zahl> max){
				max = zahl;
			}
			if(zahl<min){
				min = zahl;
			}
			System.out.println(zahl);
		}
		System.out.println("Größte Zahl war "+max+" Kleinste Zahl war "+min); //Größte und kleinste anzeigen
	}
}