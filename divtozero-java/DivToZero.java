public class DivToZero {

	public String lastTwo(int num, int factor) {
		int startans = num - num%100;
		String ans = "";
		for(int i = 0; i < 100; i++){
			if((startans + i)%factor == 0){
				ans = String.valueOf(i);
				if(i <= 9){
					ans = "0" + ans;
				}
				break;
			}
		}
		return ans;
	}

}
