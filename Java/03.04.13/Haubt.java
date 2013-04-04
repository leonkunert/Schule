/*
*
*Hausaufgaben vom 03.04.2013
*
*@version 1.0 vom 03.04.2013
*@author Leon Kunert
*
*/

public class Haubt{

	public static void main(String[] args) {
		//Aufgabe 1
		int gesamt = 1000;

		gesamt = gesamt - 333;
		gesamt = gesamt--;
		gesamt = gesamt - 200;
		System.out.println(gesamt);

		//Aufgabe 2
		//For-Schleife
		gesamt = 0;
		for (int i=0; i<=100; i++){
			gesamt = gesamt + i;
		}
		System.out.println(gesamt);
		
		//while-Schleife
		int gesamt2 = 0;
		int x = 0;
		while (x<=100) {
			gesamt2 = gesamt2+x;
			x++;
		}
		System.out.println(gesamt2);
		
		//do-while-Schleife
		int gesamt3 = 0;
		int y = 0;
		do{
			gesamt3 = gesamt3+y;
			y++;
		}while(y<=100);
		System.out.println(gesamt3);
		//Aufgabe 3 
		//for
		int gesamt4= 0;
		for (int a=0; a<=100; a++) {
			if((a%2) == 0){
				gesamt4 = gesamt4+a;
			}
		}
		System.out.println(gesamt4);

		//while
		int gesamt5= 0;
		int b = 0;
		while (b<=100) {
			if((b%2) == 0){
				gesamt5 = gesamt5+b;
			}
			b++;
		}
		System.out.println(gesamt5);

		//do while
		int c = 0;
		int gesamt6 = 0;
		do{
			if((c%2) == 0){
				gesamt6 = gesamt6+c;
			}
			c++;
		}while (c<=100);
		System.out.println(gesamt6);
		//Aufgabe 4 
		//For
		long fak = 1;
		for (int d=1; d<=40; d++) {
			fak = fak*d;
		}
		System.out.println(fak);
		
		//while
		fak = 1;
		int e = 1;
		while(e<=40){
			fak = fak*e;
			e++;
		}
		System.out.println(fak);

		//Do while
		fak = 1;
		int f=1;
		do{
			fak = fak*f;
			f++;
		}while(f<=40);
		System.out.println(fak);
	}
}