public class Rounder{
	
	public int round(int n,int b){
		if(((double)n/(double)b)-n/b>0.5){
			return b*((n/b)+1); 
		}
		return b*(n/b);
	}
}