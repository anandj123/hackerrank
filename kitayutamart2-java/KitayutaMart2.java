public class KitayutaMart2 {

	public int numBought(int K, int T) {
		int cost = 0;
		for(int i = 1; i<100000000; i++){
			cost += K * Math.pow(2, i-1);
			if(cost == T){
				return i;
			}
		}
		return 0;
	}

}
