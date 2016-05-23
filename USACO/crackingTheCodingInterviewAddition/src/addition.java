class addition{
	public static void main(String[] args){
		System.out.println(add(23,-2));
		System.out.println(0xFF);
	}
	
	
	public static int add(int a, int b){
		int c = a ^ b;
		int d = a & b;
		
		while (d > 0){
			a = c;
			b = d << 1;
			
			c = a ^ b;
			d = a & b;
		}
		
		System.out.println("values " + c + " and " + d);
		return c;
	}
}