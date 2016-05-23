public class ExerciseMachine {
	
	public int getPercentages(String time) {
		
		Double timesec = convertToSeconds(time);
		
		int ans = 0;
		
		for(int i = 1; i < timesec; i++){
			Double percent =  (i*100/timesec);
			if(percent%1 == 0){
				ans++;
			}
		}
		return ans;
	}
	public static Double convertToSeconds(String time){
		String hours = time.substring(0,2);
		String minutes = time.substring(3,5);
		String seconds = time.substring(6);
		return  (Double.parseDouble(hours) * 3600) + (Double.parseDouble(minutes) * 60) + (Double.parseDouble(seconds));	
	}

}
