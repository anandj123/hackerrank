public class ComboLength {

	public int howLong(String moves) {
		int actans = 0;
		int ans = 1;
		for(int i = 0; i < moves.length() - 1; i++){
			if(moves.charAt(i) == moves.charAt(i + 1)){
				ans++;
				actans = Math.max(ans, actans);
			}
			ans = 0;
		}
		return actans;
	}

}
