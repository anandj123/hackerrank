import java.util.Arrays;

public class Cable {
	private static int[][] in ={ {5} , {11, 27}, {84, 99}, {142, 81}, {88, 30}, {95, 38}};
	//274.40, 1 4 5 2 3
	//  1 2 3 4 5
	//  1 4 5 2 3
	
	public static void main(String[] args) {
		int[] input = new int[in[0][0]];
		Arrays.fill(input, 0);
		System.out.println(findPath(input, 1));
	}
	
	public static double findPath(int[]nodesUsed, int node){
		if(node > in[0][0]){
			return calculatedPath(nodesUsed);
		}
		double pathLength = Double.MAX_VALUE;
		for(int i = 0; i < nodesUsed.length; i++){
			if(nodesUsed[i] == 0){
				nodesUsed[i] = node;
				pathLength  = Math.min(findPath(nodesUsed, node + 1), pathLength);
				nodesUsed[i] = 0;
			}
		}
		return pathLength;
	}
	
	public static double calculatedPath(int[]nodesUsed){
		double ans = 16.0 * (in[0][0] -1);
		
		for(int i = 2; i < in[0][0] + 1; i++){
			int startPos = -1;
			int endPos   = -1;
			
			for (int j=0;j<nodesUsed.length; j++){
				if (nodesUsed[j] == i -1){
					startPos = j;
				}
				if (nodesUsed[j] == i){
					endPos = j;
				}
				if (startPos > -1 &&
					endPos > -1){
					ans += Math.sqrt(Math.pow((in[startPos + 1][0] - in[endPos + 1][0]), 2) + 
							(Math.pow((in[startPos + 1][1] - in[endPos + 1][1]), 2)));
					break;
				}
			}
		}
		return ans;
	}
}
