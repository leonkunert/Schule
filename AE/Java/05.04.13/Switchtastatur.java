import java.util.*;
public class Switchtastatur{

	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		int zahl1, zahl2;
		zahl1 = tastatur.nextInt();
		switch (zahl1) {
			case 1:
				System.out.println("Eins");
				break;
			case 2:
				System.out.println("Zwei");
				break;
			default:
				System.out.println("Was außer Eins und Zwei.");
				break;
		}
	}
}