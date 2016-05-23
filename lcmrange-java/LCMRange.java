public class LCMRange {

	public int lcm(int first, int last) {
		for(int ans = last; ans < Integer.MAX_VALUE; ans++){
			for(int i = first; i <(last+1); i++){
				if(ans % i == 0){
					return ans;
				}
			}
		}
		return 0;
	}

}
