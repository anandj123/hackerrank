import java.util.Arrays;

public class GraphColor{
	public static int[][] input = {{1,1},{6,8}, {1,2}, {1,3}, {2,4},{2,5},{3,4},{3,6},{4,6},{5,6}};
	public static int[] nodeColor = new int[input[1][0]];
	public static int maxBlack = 0;

	public static void main(String[] args){
		Arrays.fill(nodeColor, -1);	
		colorGraph(1);
	}
	
	public static boolean colorGraph(int n){
		if(n > 6){
			return false;
		}
		
		
		
		if (canBeBlack(n)){
			nodeColor[n-1] = 1;
			colorGraph(n+1);
			
			if (maxBlack < numberOfBlackNodes()){
				maxBlack = numberOfBlackNodes();
				printBlackNodes();
			}
		}
		
		//Make node white
		nodeColor[n-1] = 0;
		colorGraph(n+1);
		if (maxBlack < numberOfBlackNodes()){
			maxBlack = numberOfBlackNodes();
			printBlackNodes();
		}
		
		return false;
	}
			
	public static boolean canBeBlack(int n){
		for(int i=2; i< input.length; i++){
			//first node is current node in this connection
			if (input[i][0] == n){
				if(nodeColor[input[i][1] - 1] == 1 ){
					return false;
				}
			}
			//second node is current node in this connection
			if(input[i][1] == n){
				if(nodeColor[input[i][0] - 1] == 1){
					return false;
				}
			}
		}
		return true;
	}
	
	public static int numberOfBlackNodes(){
		int counter = 0;
		for (int j=0; j<nodeColor.length;j++){
			if (nodeColor[j] == 1){
				counter++;
			}
		}
		return counter;
	}
	public static void printBlackNodes(){
		for (int j=0; j<nodeColor.length; j++){
			if (nodeColor[j] == 1){
				System.out.print((j + 1) + ",");
			}
		}
		System.out.println();
	}
}