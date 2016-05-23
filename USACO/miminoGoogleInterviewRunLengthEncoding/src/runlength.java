/*
 * Given is sequence of numbers: 1, 11, 21, 1211, 111221, ... 
 * Find out how the sequence works and create the function to compute the next element.
 */
class runlength{
	public static String input = "312211";
	public static void main(String[] args){
		System.out.println("input " + input);
		System.out.println(nextSeq(input));
	}
	
	public static String nextSeq(String in){
		String retVal = "";
		char current = in.charAt(0);
		int count = 1;
		for (int i=1;i<in.length(); i++){
			if (in.charAt(i) != current){
				retVal += String.valueOf(count) + String.valueOf(current);
				current = in.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		retVal += String.valueOf(count) + String.valueOf(current);
		
		return retVal;	
	}
}