public class JustifyText {

	public String[] format(String[] text){
		String[] ans = text;
		int maxlength = 0;
		for(int i = 0; i < text.length; i++){
			maxlength = Math.max(maxlength, text[i].length());
		}
		for(int i = 0; i < text.length; i++){
			String anse = text[i];
			for(int r = 0; r < maxlength+1; r++){
				if(text[r].length() < maxlength){
					anse = " " + anse;
				}
			}
			text[i] = anse;
		}
		return ans;
	}
}
