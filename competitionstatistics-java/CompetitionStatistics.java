public class CompetitionStatistics {

	public int consecutiveGrowth(int[] ratingChanges) {
		int maxans = 0;
		int ans = 0;
		for(int i = 0; i < ratingChanges.length; i++){
			if(ratingChanges[i] > 0){
				ans++;
				maxans = Math.max(ans, maxans);
			}
			else{
				ans = 0;
			}
		}
		return maxans;
	}

}
