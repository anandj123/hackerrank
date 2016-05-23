public class add{
	public static void main (String[] args){
		int a      = Integer.parseInt(args[0]);
		int b      = Integer.parseInt(args[1]);
		int c      = Integer.parseInt(args[2]);
		
		double root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
		double root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
		
		System.out.println(root1);
		System.out.println(root2);
		
	}
}