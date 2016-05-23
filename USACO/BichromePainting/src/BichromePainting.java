
public class BichromePainting {
	private static int boardsize = 4;
	private static int paintersize = 3;
	private static String[] finalState = {"BBBW",
			 							  "BWWW",
			 							  "BWWW",
			 							  "WWWW"};
	private static String[] boardState = {"WWWW",
										  "WWWW",
										  "WWWW",
										  "WWWW"};
	private static String[] boardStateSave = {"WWWW",
		  "WWWW",
		  "WWWW",
		  "WWWW"};
	public static void main(String[] args) {
		compute(0);
	}
	
	private static boolean compute(int startIndex){
		if (startIndex>=boardsize*boardsize) {
			return false;
		}
		
		if (isSame()){
			return true;
		}
		for (int i=startIndex; i<boardsize*boardsize; i++){
			int row1 = i/(boardsize - 1);
			int col1 = i % (boardsize);
			//No change and recurse
			if (compute(i+1)){
				System.out.println("found a match for index " + startIndex + " with NO CHANGE" );
				return true;
			}
			
			//Paint black and recurse
			boolean painted = paint(row1, col1, "B");
			if (!painted){
				continue;
			}
			if (isSame()){
				System.out.println("found a match for index " + startIndex + " with BLACK" );
				return true;
			}
			
			if (compute(i+1)){
				System.out.println("found a match for index " + startIndex + " with BLACK" );
				
				return true;
			} else {
				revertState();
			}
			
			//Paint white and recurse
			painted = paint(row1, col1, "W");
			if (!painted){
				continue;
			}
			if (isSame()){
				System.out.println("found a match for index " + startIndex + " with WHITE" );
				return true;
			}
			if (compute(i+1)){
				System.out.println("found a match for index " + startIndex + " with WHITE" );
				
				return true;
			} else {
				revertState();
			}
		}
		return false;
	}
	
	private static boolean paint(int row, int col, String color){
		saveState();
		if (row + paintersize > boardsize ||
			col + paintersize > boardsize) {
			return false;
		}
		
		for (int k= row; k<row+paintersize; k++){
			for (int k1=col; k1<col+paintersize; k1++){
				boardState[k] = boardState[k].substring(0,k1) + color + boardState[k].substring(k1+1, boardState[k].length());
			}
		}
		return true;
		
	}

	private static boolean isSame(){
		for (int k2=0; k2<boardsize; k2++){
			if (!boardState[k2].equals(finalState[k2])){
				return false;
			}
		}
		return true;
	}
	private static void saveState(){
		for (int k3=0; k3<boardsize; k3++){
			boardStateSave[k3]= boardState[k3];
		}
	}
	
	private static void revertState(){
		for (int k3=0; k3<boardsize; k3++){
			boardState[k3]= boardStateSave[k3];
		}
	}
}
