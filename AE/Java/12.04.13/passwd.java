import java.util.*;

public class passwd{
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		System.out.println("Gib die Anzahl von Zeichen für dein Passwort ein:");
		int zahl1 = tastatur.nextInt();
		Random random = new Random();
		char passwd[] = new char[zahl1];
		for(int i = 0;i<zahl1;i++){
			String zufall = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!?§$%&+*#";
			passwd[i] = zufall.charAt(random.nextInt(zufall.length()));
		}
		for ( char item : passwd) {
			System.out.print(item);
		}
		System.out.println();
	}
}