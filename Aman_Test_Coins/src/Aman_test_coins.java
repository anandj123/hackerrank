public class Aman_test_coins{
	static int[] coins = {1,5,10,21,25};
	
	public static void main(String[] args){
		int change = 68;
		System.out.println(giveCoins(change));
	}
	
	public static int giveCoins(int change){
		if(change <= 0){
			return 0;
		}
		int minCoins = Integer.MAX_VALUE;
		for(int p =0; p< coins.length;p++){
			if(coinFits(change, coins[p])){
			    int c = giveCoins(change - coins[p]) + 1;
			    if(minCoins > c){
			    	minCoins = c;
			    }
			}
		}
		return minCoins;
	}
	
	public static boolean coinFits(int change, int coinVal){
		return(coinVal <= change);
	}
}