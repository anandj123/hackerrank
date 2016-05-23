
public class fib {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibIter(48));
		int x = 5;
		x = 3;
		System.out.println(x);
	}
	
	public static long fibRecurse(int n){
		if (n == 0){
			return 1;
		}
		if (n == 1){
			return 1;
		}
		return fibRecurse(n-2) + fibRecurse(n-1);
	}

	public static long fibIter(int n){
		if (n == 0){
			return 1;
		}
		if (n == 1){
			return 1;
		}

		long retVal = 0;
		long i1=1;
		long i2=1;
		for (int i=2; i<n+1; i++){
			retVal = i1 + i2;
			i1 = i2;
			i2 = retVal;
		}
		return retVal;
	}
}
