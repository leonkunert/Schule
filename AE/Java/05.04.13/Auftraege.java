/*
*Aufgabe B
*3a) 3 
*b) for
*c) 5
*d)zwei for-Schleifen in einer For-Schleife
*@author Katharina + Leon
*
*/

public class Auftraege{

	public static void main(String[] args) {
		int anz 	=7; //maximum length 
		String str 	="";
		for (int i = 1; i<=anz;i++) {//Printing lines
			for(int x = 1; x<=(anz-i); x++){//Printing spaces
				str = str+" ";
			}
			for(int y = 1; y<=i; y++){//Printing Numbers
				str = str+i;
			}
			System.out.println(str);//printing variable in the console
			str = "";
		}
	}
}