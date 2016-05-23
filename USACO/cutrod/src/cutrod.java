class cutrod{
	public static int[] prices = {1, 5, 8, 9, 10, 17};
	public static int[] maxCutVal = new int[8];
	
	public static void main (String[]args){
		for (int i = 0; i< maxCutVal.length; i++){
			maxCutVal[i] = 0;
		}
		
		int valueReturned = rodCut(8); 
		System.out.println(valueReturned);
		
	}
	
	public static int rodCut(int length){
		System.out.println("called with length = " + length);
		
		if (length <= 0) {
		     return 0;
		}
		int max_val = 0;
		 
	   // Recursively cut the rod in different pieces and compare different configurations
	   for (int i = 0; i<prices.length; i++) {
		   if (length - i - 1 >= 0){
			   max_val = Math.max(max_val, prices[i] + rodCut(length-i-1));
			   System.out.println("max value so far = " + max_val);
		   }
	   }
	   
	   maxCutVal[length-1] = max_val;
	   return max_val;
	}
}