import java.util.Arrays;

public class Uva10344 {
	public static int[] in = {1,2,3,4,5};
	public static void main(String[] args) {
		int[] used = {0,0,0,0,0};
		System.out.println(find23(0,used));
	}
	public static String find23(int ans, int[] used){
		if(ans == 23){
			System.out.println("Possible");
			System.out.println(Arrays.toString(used));
			return "Possible";
			
			
		}
		if(allUsed(used)){
			return "Impossible";
		}
		for(int i = 0; i<used.length; i++){
			if(used[i] == 0){
				used[i] = 1;
				find23(ans + in[i], used);
				find23(ans - in[i], used);
				find23(ans * in[i], used);
				find23(ans / in[i], used);
				used[i] = 0;
			}
		}
		return "kjhg";
	}
	public static boolean allUsed(int[] used){
		int counter = 0;
		for(int i = 0; i < used.length; i++){
			if(used[i] == 1){
				counter++;
			}
		}
		return(counter == used.length);
	}

}
