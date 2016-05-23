class permutestring{
	public static String input="abc";
	
	public static void main (String [] args){
		permutations(0);
	}
	
	public static int permutations(int index){
		System.out.println("called with index " + index);
		int retVal = 0;
		
		// if we reach end of string then return 1 (only 1 permutation is allowed.
		if (index == input.length()-1){
			return  1;
		}
		
		//else number of permutaiton is 1 (current index) + 2 * (permuation without current element)
		
		retVal = 1 + 2 * permutations(index + 1);
		System.out.println("total number of permutations = " + retVal);
		return retVal;
		
	}
}