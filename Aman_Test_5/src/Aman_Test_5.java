import java.util.Arrays;

public class Aman_Test_5{
	
	private static int[] board = new int[64];
	
	public static void main(String[] args){
		Arrays.fill(board, -1);
		placeQueen(0);
		
	}
	
	private static int placeQueen(int q){
		if (q >= 8){
			return -1;
		}
		
		for (int i=0; i< board.length; i++){
			if (validQueenPosition(i)){
				board[i] = 1;
				placeQueen(q+1);
				if (numberOfQueensPlaced()==8){
					return 0;
				}
				board[i] = -1;
			}
		}
		
		return -1;
	}
	private static int numberOfQueensPlaced(){
		int retVal = 0;
		for (int j=0; j<board.length; j++){
			if (board[j]==1){
				retVal++;
			}
		}
		return retVal;
	}
	private static boolean validQueenPosition(int i){
		int row = i/8;
		int col = i%8;
		
		//any queen on this row
		for (int j=0; j<board.length; j++){
			if (board[j] == 1){
				int qrow = j/8;
				if (qrow == row){
					return false;
				}
			}
		}
		//any queen on this column
		for (int j=0; j<board.length; j++){
			if (board[j] == 1){
				int qcol = j%8;
				if (qcol == col){
					return false;
				}
			}
		}
		//any queen in left diagonal
		//		4 4 (original queen position)
		//		5 3 - 1 1
		//		3 5 - 1 1		
		//		6 2 - 2 2
		//		2 6 - 2 2
		//		1 7 - 3 3
		//		7 1 - 3 3
 		//any queen in right diagonal
		for (int j=0; j<board.length; j++){
			if (board[j] == 1){
				int qrow = j/8;
				int qcol = j%8;
				if (Math.abs(qcol - col) == Math.abs(qrow -row)){
					return false;
				}
			}
		}
		return true;
	}
}