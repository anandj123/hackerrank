public class DecipherabilityEasy {

	public String check(String s, String t) {
		int counter = 0;
		if(s.length() == t.length()+1){
			for(int i = 0; i<s.length(); i++){
				String s1 = s.substring(0, i) + s.substring(i+1);
				if(s1.equals(t)){
					counter++;
					break;
				}
			}
			
			if (counter == 1){
				return "Possible";
			}
			else {
				return "Impossible";
			}
		}
		
		else{
			return "Impossible";
		}
	}

}
