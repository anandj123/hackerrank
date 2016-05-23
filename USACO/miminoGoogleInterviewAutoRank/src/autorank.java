import java.util.Arrays;

class autorank{
	public static int[] input	= {6, 0, 4,3};
	public static int[] rank  = {0,0,0,0};
	public static void main(String[] args){
		System.out.println("input array " + Arrays.toString(input));
		rank(input);
		System.out.println("rank array  " + Arrays.toString(rank));
		
	}
	
	public static void rank(int[] in){
		
		for (int i=0; i<in.length; i++){
			for (int j=i; j<in.length; j++){
				if (in[i] > in[j]){
					rank[i]++;
				} else {
					rank[j]++;
				}
			}
		}
		
	}
	
}