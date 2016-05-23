import java.util.Arrays;

/*
 * http://www.quora.com/What-interview-questions-does-Google-ask
 * 
 * Given is array containing N numbers, A[0], A[1], ... A[N-1]. 
 * Compute the array B of length N, such that B[i] = A[0]*A[1]*...A[i-1]*A[i+1]...*A[N-1]. 
 * Algorithm should work in time O(N), memory O(1) and can't use division.
 */
class multalgo{
	public static int[] N = {3, 2, 5, 9};
	public static int[] B = {1, 1, 1, 1};
	
	public static void main(String[] args){
		System.out.println("input" + Arrays.toString(N));
		compute();
		System.out.println("output" + Arrays.toString(B));
		
	}
	
	public static void compute(){
		//forward pass
		int b = 1;
		for (int i=0;i<N.length; i++){
			B[i] = b;
			b *= N[i];
		}
		
		//backward pass
		b = 1;
		for (int i=N.length-1;i>=0; i--){
			B[i] *= b;
			b *= N[i];
		}
		
	}
}