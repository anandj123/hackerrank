import java.util.Arrays;

public class FilipTheFrog {
	
	public static void main(String[] args) {
		FilipTheFrog f = new FilipTheFrog();
		int[] positions = {4, 7, 1, 3, 5};
		int L = 1;
		f.countReachableIslands(positions, L);
	}
	
	public int countReachableIslands(int[] positions, int L){
	    int retVal = 1;
	    int frogIsland = positions[0];
		Arrays.sort(positions);
		for (int i=0; i<positions.length; i++){
			if (positions[i] == frogIsland) {
				// Search left islands
				int frogIslandL = frogIsland;
				for (int j=i-1; j>=0; j--){
					if (frogIslandL - positions[j] <= L){
						frogIslandL = positions[j];
						retVal++;
					}
					else {
						break;
					}
				}
				// Search right islands
				int frogIslandR = frogIsland;
				for (int j=i+1; j<positions.length; j++){
					if (positions[j] - frogIslandR  <= L){
						frogIslandR = positions[j];
						retVal++;
					}
					else {
						break;
					}
				}
				break;
			}
		}
		System.out.println(retVal);
		return retVal;
	}

}
