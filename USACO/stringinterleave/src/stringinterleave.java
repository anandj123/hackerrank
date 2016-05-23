import java.util.Arrays;

class stringinterleave{
	public static String s1 = "ABCD";
	public static String s2 = "XYZ";
	public static String matchString = "ABADXUABVYCDZ";
	public static int[] s1a = new int[matchString.length()];
	public static int[] s2a = new int[matchString.length()];
	
	public static void main (String[] args){
		Arrays.fill(s1a, -1);
		Arrays.fill(s2a, -1);
		
		for (int i=0;i<matchString.length(); i++){
			System.out.print(matchString.charAt(i) + " ");
		}
		System.out.println("");
		
		for (int i=0;i<s1.length(); i++){
			System.out.print(s1.charAt(i) + " ");
		}
		System.out.println("");
		
		for (int i=0;i<s2.length(); i++){
			System.out.print(s2.charAt(i) + " ");
		}
		System.out.println("\n----------------------------------");
		
		
		boolean match = interLeaveS1(0);
		System.out.println(match);
		for (int i=0;i<matchString.length(); i++){
			if (s1a[i]>-1){
				System.out.print(matchString.charAt(i) + " ");
			}
			else {
				System.out.print("*" + " ");
			}
		}
		System.out.println("");
		for (int i=0;i<matchString.length(); i++){
			if (s2a[i]>-1){
				System.out.print(matchString.charAt(i) + " ");
			}
			else {
				System.out.print("*" + " ");
			}
		}
		System.out.println("");
		System.out.println(Arrays.toString(s1a));
		System.out.println(Arrays.toString(s2a));
	}
	
	public static boolean interLeaveS1(int index){
		int retLoc = -1;
		boolean searchs2 = false;
		
		if (index >= s1.length()){
			return true;
		}
		
		for (int i=0;i<matchString.length(); i++){
			retLoc = searchMatch(index, i);
			//If all the condition for the string satisfies and we found the character match
			if (retLoc >= 0 ){
				s1a[retLoc] = index;
				if (index == s1.length() -1){
					//we find that all of the first string is found. now search second string.
					searchs2 = true;
					break;
				}
				
				// increment the index (search next character)
				boolean retVal1 = interLeaveS1(index+1);
				if (retVal1 == true){
					//If we find that there is a match from next character till end
					return true;
				}
				else {
					//reset our current selection and keep searching the search space.
					s1a[retLoc] = -1;
				}
			}
		}
		
		if (searchs2){
			boolean retVal2 = interLeaveS2(0);
			if (retVal2 == true){
				return true;
			}
			else {
				s1a[retLoc] = -1;
				return false;
			}
		}
		return false;
	}
	
	public static int searchMatch(int index, int matchStringIndex){
		int retVal = -1;
		boolean prevFound = false;
		
		for (int i=0; i<=matchStringIndex; i++){
			if (s1a[i] == index -1){
				prevFound = true;
			}
		}
		
		if (s1a[matchStringIndex] == -1 &&
			prevFound == true &&
			matchString.charAt(matchStringIndex) == s1.charAt(index)){
			return matchStringIndex;
		}
		
		return retVal;
	}
	public static boolean interLeaveS2(int index){
		int retLoc = -1;
		if (index >= s2.length()){
			return true;
		}
		
		for (int i=0;i<matchString.length(); i++){
			retLoc = searchMatch2(index, i);
			if (retLoc >= 0 ){
				s2a[retLoc] = index;
				if (index == s2.length() -1){
					return true;
				}
				
				boolean retVal1 = interLeaveS2(index+1);
				if (retVal1 == true){
					return true;
				}
				else {
					s2a[retLoc] = -1;
				}
			}
		}
		return false;
	}
	public static int searchMatch2(int index, int matchStringIndex){
		int retVal = -1;
		boolean prevFound = false;
		
		// to see if the order is find for the current index
		for (int i=0; i<matchStringIndex; i++){
			if (s2a[i] == index -1){
				prevFound = true;
				break;
			}
		}
		
		// we should not double count any character that is already counted.
		if (s2a[matchStringIndex] == -1 &&
				prevFound == true &&
				matchString.charAt(matchStringIndex) == s2.charAt(index) &&
				s1a[matchStringIndex] == -1){
			return matchStringIndex;
			}

		return retVal;
	}
}