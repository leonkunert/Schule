public class Lotto{

	public static void main(String[] args) {
		int user_numbers[] = new int[6]; //Array to save the numbers
		int temp;	//sorting variable
		int price_game = 5;
		user_numbers[0] = 3;
		user_numbers[1] = 13;
		user_numbers[2] = 23;
		user_numbers[3] = 22;
		user_numbers[4] = 26;
		user_numbers[5] = 38;
		long games_played = 0;
		boolean not_won = true;
		int lotto_numbers[] = new int[6]; //Variable to save the generated lotto numbers
		/*generating random numbers
		for(int i = 0; i< user_numbers.length; i++){
			user_numbers[i]= (int) (Math.random()*(42)+1);
		}*/
		//sorting the numbers
		for (int j=1; j<user_numbers.length;j++){
			for(int i=0; i<user_numbers.length-1; i++){
				if(user_numbers[i]> user_numbers[(i+1)]){
					temp = user_numbers[i];
					user_numbers[i] = user_numbers[(i+1)];
					user_numbers[(i+1)] = temp;
				}
			}
		}
		//
		System.out.println("Ihre Lottozahlen lauten: ");
		for (int user_number:user_numbers){
			System.out.print(user_number+", ");
		}
		//generating the lotto numbers
		for(int i = 0; i< lotto_numbers.length; i++){
			lotto_numbers[i]= (int) (Math.random()*(42)+1);
		}
		long startTime = System.nanoTime();
		while(not_won){
			/*System.out.println("Die Lottozahlen dieser Woche lauten: ");
			for (int lotto_number:lotto_numbers){
				System.out.print(lotto_number+", ");
			}
			System.out.println("");*/
			if(lotto_numbers[0] == user_numbers[0] && lotto_numbers[1] == user_numbers[1] && lotto_numbers[2] == user_numbers[2] && lotto_numbers[3] == user_numbers[3] && lotto_numbers[4] == user_numbers[4] && lotto_numbers[5] == user_numbers[5]){
				not_won = false;
				System.out.println("You Won !!!!!!! After you played "+games_played+" Games and payed "+(games_played*5)+"Euro");
				long endTime = System.nanoTime();
				System.out.println("Took "+((endTime - startTime)/1000000000) + " s"); 
			}
			if((games_played % 1000000000)==0){
				System.out.println(games_played);
				long endTime = System.nanoTime();
				System.out.println("Took "+((endTime - startTime)/1000000000) + " s"); 
			}
			for(int i = 0; i< lotto_numbers.length; i++){
				lotto_numbers[i]= (int) (Math.random()*(42)+1);
			}
			games_played++;
		}
	}
}