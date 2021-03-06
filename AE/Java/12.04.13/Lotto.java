import java.util.Scanner;

public class Lotto {

	/**
	 * @autor Leon Kunert
	 * @param args
	 */
	public static void main(String[] args) {
		//Array to save the users Lotto numbers
		int user_numbers[] = new int[6];
		Scanner scan = new Scanner(System.in);
		boolean notwon = true;
		//filling the Array user_numbers with numbers
		for(int i =0; i<user_numbers.length; i++){
			user_numbers[i] = scan.nextInt();
			System.out.println("Nächste Zahl bitte.");
			if(user_numbers[i] > 49){
				i--;
				System.out.println("Bitte nur Zahlen bis 49.");
				user_numbers[i] = scan.nextInt();
			}
		}
		scan.close();
		System.out.println("Ihre Lottozahlen lauten: ");
		for (int user_number:user_numbers){
			System.out.print(user_number+", ");
		}
		while(notwon){
			int[] lotto_numbers = generateNumbers(6);
			if(checkWon(user_numbers, lotto_numbers)){
				
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
