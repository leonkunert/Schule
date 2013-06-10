import java.util.Random;
import java.util.Scanner;

public class password {

	/**
	 * @author Leon Kunert
	 * @param args
	 * Function to generate a random Password of specified lenght
	 */
	public static void main(String[] args) {
		//New Scanner to get length of password
		Scanner scan = new Scanner(System.in);
		//Print welcome-msg.
		System.out.println("Geben sie die Länge ihres Passwords an. Mindestens 4.");
		int length = scan.nextInt();
		//If length smaller -> than 4 print errormsg.
		if(length < 4){
			System.out.println("Wir wollen doch ein sicheres Password oder? Also besser mal länger als 4 Zeichen.");
		}else{
			//Execute Function to generate password
			char[] password = generatePassword(length);
			System.out.println("Ihr Password lautet: ");
			for(char buchst:password){
				System.out.print(buchst);
			}
		}
	}
	/**
	 * Function generatePassword
	 * @param length
	 * @return char in Array
	 * 
	 */
	private static char[] generatePassword(int length){
		//Creating Array of length to save the password
		char[] password = new char[length];
		//New Random Object
		Random rand = new Random();
		//Booleans to show if type is already used
		boolean special = false;
		boolean number = false;
		boolean upper = false;
		boolean lower = false;
		boolean generated = false;
		
		//Generation of the password
		for(int i= 0;i<length;i++){
			generated = false;
			//generating random int to randomize what char-type is where
			int type = rand.nextInt(4);
			//generating Special
			if(type == 0 && special != true ){
				password[i] = generateSpecial();
				special = true;
				generated = true;
			}
			//generating Number
			if(type == 1 && number!= true){
				password[i] = generateNumber();
				number = true;
				generated = true;
			}
			//generating Uppercase
			if(type == 2 && upper!= true){
				password[i] = generateUpper();
				upper = true;
				generated = true;
			}
			//generating Lowercase
			if(type == 3 && lower != true){
				password[i] = generateLower();
				lower = true;
				generated = true;
			}
			//Randomization did'nt work do it all over for the rest if password length is still under 4
			if(generated == false && i<4 && special==false){
				password[i] = generateSpecial();
				special = true;
				generated = true;
			}
			if(generated == false && i<4 && number==false){
				password[i] = generateNumber();
				number = true;
				generated = true;
			}
			if(generated == false && i<4 && upper==false){
				password[i] = generateUpper();
				upper = true;
				generated = true;
			}
			if(generated == false && i<4 && lower==false){
				password[i] = generateLower();
				lower = true;
				generated = true;
			}
			//If length of password is already greater than 4
			//generating Special
			if(type == 0 && i>4){
				password[i] = generateSpecial();
			}
			//generating Number
			if(type == 1 && i>4){
				password[i] = generateNumber();
			}
			//generating Uppercase
			if(type == 2 && i>4){
				password[i] = generateUpper();
			}
			//generating Lowercase
			if(type == 3 && i>4){
				password[i] = generateLower();
			}
		}
		return password;
	}
	/**
	 * function generates new Specialchar
	 * @return char
	 */
	private static char generateSpecial(){
		Random rand = new Random();
		char buchst = (char) (rand.nextInt(47 - 33 + 1) + 33);
		return buchst;
	}
	
	/**
	 * function generates new number
	 * @return char 
	 */
	private static char generateNumber(){
		Random rand = new Random();
		char number = (char) (rand.nextInt(57 - 48 + 1) + 48);
		return number;
	}
	
	/**
	 * function generates new Uppercase Character
	 * @return char
	 */
	private static char generateUpper(){
		Random rand = new Random();
		char buchst = (char) (rand.nextInt(90 - 65 + 1) + 65);
		return buchst;
	}
	
	/**
	 * function generates new Lowercase Character
	 * @return char
	 */
	private static char generateLower(){
		Random rand = new Random();
		char buchst = (char) (rand.nextInt(122 - 97 + 1) + 97);
		return buchst;
	}

}
