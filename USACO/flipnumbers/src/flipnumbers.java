class flipnumbers{
	public static int a = -3;
	public static int b = 5;
	public static void main(String[] args){
		
		a = a - b;
		b = a + b;
		a = -1 * (a - b);
		System.out.println("a = "  + a + " b = " + b);
		
	}
}