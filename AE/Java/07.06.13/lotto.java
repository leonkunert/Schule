import java.util.Scanner;

public class lotto {

	/**
	 * @author Leon Kunert
	 * @param args
	 */
	public static void main(String[] args) {
		//Array to save the users Lotto numbers
		int user_numbers[] = new int[6];
		Scanner scan = new Scanner(System.in);
		boolean notwon = true;
		//temporary variable to save keyboard inputs
		int temp;
		//saves the number of games
		int times_played = 0;
		//filling the Array user_numbers with numbers
		System.out.println("Ihre Zahlen Bitte.");
		for(int i =0; i<user_numbers.length; i++){
			temp = scan.nextInt();
			if(temp > 49){
				i--;
				System.out.println("Bitte nur Zahlen bis 49.");
				temp = scan.nextInt();
			}
			//Catches if someone tries to use one number twice
			for(int user_number:user_numbers){
				if(user_number == temp){
					i--;
					System.out.println("Bitte nicht eine Zahl doppelt ankreuzen.");
				}
			}
			user_numbers[i] = temp;
			System.out.println("Nächste Zahl bitte.");
		}
		scan.close();
		user_numbers = sortArray(user_numbers);
		System.out.println("Ihre Lottozahlen lauten: ");
		for (int user_number:user_numbers){
			System.out.print(user_number+", ");
		}
		while(notwon){
			int[] lotto_numbers = generateNumbers(6);
			times_played++;
			if(checkWon(user_numbers, lotto_numbers)){
				notwon = false;
				System.out.println("Herzlichen Grückwunsch sie haben gewonnen!! Nach "+ times_played + " Spielen und "+ (times_played/2) + " Wochen. Der Spaß hätte sie " + (times_played*5) + " Euro gekostet.");
			}
		}
	}
	/**
	 * function to sort the array it is given
	 * @param numbers
	 * @return int in Array
	 */
	
	private static int[] sortArray(int[] numbers ){
		int temp;
		for (int j=1; j<numbers.length;j++){
			for(int i=0; i<numbers.length-1; i++){
				if(numbers[i]> numbers[(i+1)]){
					temp = numbers[i];
					numbers[i] = numbers[(i+1)];
					numbers[(i+1)] = temp;
				}
			}
		}
		return numbers;
	}
	
	/**
	 * function to generate a random array of given length
	 * @param length
	 * @return int in Array
	 */
	
	private static int[] generateNumbers(int length){
		int numbers[] = new int[length];
		for(int i = 0; i< length; i++){
			numbers[i]= (int) (Math.random()*(49)+1);
		}
		return numbers;
	}
	
	/**
	 * Compares Arrays to each other
	 * @param user_numbers
	 * @param lotto_numbers
	 * @return boolean if array's are the same (true if they are, false if not)
	 */
	private static boolean checkWon(int[] user_numbers, int[] lotto_numbers){
		for(int i = 0; i<user_numbers.length; i++){
			if(user_numbers[i] != lotto_numbers[i]){
				return false;
			}
		}
		return true;
	}
}
