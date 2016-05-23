import java.util.Arrays;

/*
 * Given is array A containing N numbers. Find three different indexes i,j,k, 
 * such that A[i]+A[j]+A[k] == 0. Algorithm should work in time O(N^2).
 */
class threeindex{
	public static int [] input = {5, 3, 2, -7, -5, 4};
	public static int [] temp  = {0, 0, 0, 0, 0,  0};
	public static void main(String[]arg){
		int[] output = findijk(input);
		System.out.println("outout " + Arrays.toString(output));
	}
	
	public static int[] findijk(int[] in){
		int[] retVal = {0, 0, 0};
		for (int i = 0; i< in.length; i++){
			for (int j = i+1; j<in.length; j++){
				temp[j] = in[i] + in[j];
				
				for (int k=j-1; k>i;k--){
					int sum = temp[k] + in[j];
					System.out.println(sum);
					if (sum == 0){
						retVal[0] = i;
						retVal[1] = j;
						retVal[2] = k;
						return retVal;
					}
				}
			}
		}
		return retVal;
	}
}