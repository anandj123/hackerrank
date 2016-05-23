public class InfiniteString {

	public String equal(String s, String t) {
		if (s.length() <= t.length()){
			// check s in t
			int i = 0;
			int j = 0;
			while (true){
				if (s.charAt(i) != t.charAt(j)){
					return "Not equal";
				}
				i++;
				j++;
				if (i==s.length()){
					i=0;
				}
				if(j==t.length()){
					return "Equal";
				}
				
			}
		} else {
			// check t in s
			int i = 0;
			int j = 0;
			while (true){
				if (s.charAt(i) != t.charAt(j)){
					return "Not equal";
				}
				i++;
				j++;
				if (i==s.length()){
					return "Equal";
				}
				if(j==t.length()){
					j=0;
				}
				
			}
			
		}
	}

}
