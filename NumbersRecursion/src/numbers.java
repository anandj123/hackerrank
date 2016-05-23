public class numbers{
	
	//public static int[] in = {10,13, 21, 8, 16, 22, 18};
	public static int[] in = {10,13,8,14};
	public static void main(String[] args){
		int ans = chain(0, 0, 0);
		System.out.println(ans);
	}
	
	public static int chain(int n, int highest, int counter){
		if(n >= in.length){
			return counter;
		}
		
		int maxCounter = 0;
		int retCounter = 0;
		if(in[n] >= highest){
			//choose
			retCounter = chain(n+1, in[n], counter + 1);
			maxCounter = Math.max(counter, retCounter);
			
			//do not choose
			retCounter = chain(n+1, highest, counter);
			maxCounter = Math.max(counter, retCounter);
		}
		
		if(in[n] < highest){
			//choose
			retCounter = chain(n+1, in[n], 1);
			maxCounter = Math.max(counter, retCounter);
			
			//dont choose
			retCounter = chain(n+1, highest, counter);
			maxCounter = Math.max(counter, retCounter);
		}
		
		return maxCounter;
	}
	
}