
public class foregetfulMath {

	public static void main(String[] args) {
		System.out.println(smallestSum("1289"));
	}
	
	private static String smallestSum(String input){
		int sum = Integer.MAX_VALUE;
		for (int i=0; i<input.length()-1; i++){
			int left = Integer.parseInt(input.substring(0, i+1));
			int right = Integer.parseInt(input.substring(i+1, input.length()));
			if (left+right < sum){
				sum = left + right;
			}
			
		}
		
		return "" + sum;
	}
}
