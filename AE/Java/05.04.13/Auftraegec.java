public class Auftraegec{

	public static void main(String[] args) {
		int anz 	=9; //maximum length 
		String str 	="";
		for (int i=1; i<=anz;i= i+2) {//Printing lines

			for(int x=1; x<=((anz-i)/2);x++){
				str += " ";
			}
			for(int y = 1; y<=i; y++){//Printing Numbers
				str = str+i;
			}
			System.out.println(str);//printing variable in the console
			str = "";
		}
	}
}