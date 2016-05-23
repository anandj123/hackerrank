public class DifferentStrings {

	public int minimize(String A, String B) {
		int retVal = A.length();
		if (A.length() == B.length()){
			for(int i=0; i<A.length(); i++){
				if (A.charAt(i) == B.charAt(i)){
					retVal--;
				}
			}
			return retVal;
		}
		
		int misMatch = A.length();
		for(int i=0;i<A.length(); i++){
			for(int j=0;j<B.length();j++){
				// found first match
				if(A.charAt(i) == B.charAt(j)){
					System.out.println("i = " + i + " j = " + j);
					for(int k1=i;k1<A.length();k1++){
						if (k1 + (j-i) >= B.length()){
							break;
						}
						if (A.charAt(k1) == B.charAt(k1 + (j-i))){
							misMatch--;
						}
					}
					System.out.println(misMatch);
				}
				if (misMatch<retVal){
					retVal = misMatch + i;
				}
				misMatch = A.length(); 
			}
		}
		return retVal;
	}

}
