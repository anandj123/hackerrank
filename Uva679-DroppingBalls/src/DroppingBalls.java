import java.util.Arrays;

public class DroppingBalls{
	public static void main(String[] args){
		int ballPos = 1;
		int [] input = {8,128};
		int[] tree = new int[(int)Math.pow(2, input[0]) - 1];
		
		Arrays.fill(tree, 0);
		for(int ball = 0; ball < input[1]; ball++){
			ballPos = 1;
			for(int depth = 0; depth < input[0] - 1; depth++){
				if (tree[ballPos - 1] == 0){
					tree[ballPos - 1] = 1;
					ballPos = 2 * ballPos;
				}
				else{
					tree[ballPos  -1] = 0;
					ballPos = 2 * ballPos + 1;
					
				}
			}
		}
		System.out.println(ballPos);
	}
}