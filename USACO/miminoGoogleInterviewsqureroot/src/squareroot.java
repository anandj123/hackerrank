class squareroot{
	public static void main(String[] args){
		double sqrt1 = squareroot(3.0);
		
		System.out.println("square root is : " + sqrt1);

	}
	
	public static double squareroot(double input){
		double precision = 0.001;
		double start = 0.0;
		double end   = input;
		
		if (input < 1){
			end = 1;
		}
		
		while(true){
			double mid = (start + end)/2;
			if (mid * mid == input){
				break;
			}
			
			if (mid * mid > input){
				end = mid;
			}
			else {
				start = mid;
			}
			
			if (Math.abs(((mid * mid) - input)) <= precision){
				break;
			}
		}
		
		return (start + end)/2;
	}
	
}