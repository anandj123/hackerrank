public class GuessTheNumber {

	public int noGuesses(int upper, int answer) {
		int counter = 1;
		int guess = (upper + 1)/2;
		
		while(guess != answer){
			if(guess < answer){
				guess = (guess +1 + upper)/2;
				counter ++;
			}
			if(guess > answer){
				guess = (guess )/2;
				counter ++;
			}
		}
		return counter;
	}

}
