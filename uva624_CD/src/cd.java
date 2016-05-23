public class cd {
	private static int[] input = {20,4,10,5,7,4};
	public static void main(String[] args) {
		System.out.println(fillTape(2,input[0])); 
	}
	public static int fillTape(int track, int spaceLeft){
		if(track >=input.length){
			return Integer.MAX_VALUE;
		}
		int retval = Integer.MAX_VALUE;
		if(spaceLeft - input[track] > 0){
			retval = Math.min(fillTape(track + 1, spaceLeft - input[track]), spaceLeft - input[track]);
		}
		retval = Math.min(fillTape(track+ 1, spaceLeft), retval);
		return retval;
	}
}