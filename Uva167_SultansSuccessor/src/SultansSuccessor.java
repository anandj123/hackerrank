import java.util.Arrays;

public class SultansSuccessor {
	public static void main(String[] args) {
		int [] input = new int[64];
		Arrays.fill(input, -1);
		
		System.out.println(placeQueen(input));
	}
	public static int placeQueen(int[]board){
		if(numQueens(board)>=8){
			return sumQueens(board);
		}
		int retval = Integer.MIN_VALUE;
		for(int i = 0; i< board.length; i++){
			if(canPlaceQueen(board, i)){
				board[i] = 1;
				retval = Math.max(placeQueen(board), retval);
				System.out.println(retval);
				board[i] = -1;
			}
		}
		return retval;
	}
	public static int numQueens(int[]board){
		int counter = 0;
		for(int i =0; i < board.length; i++){
			if(board[i] == 1){
				counter++;
			}
		}
		return counter;
	}
	public static int sumQueens(int[]board){
		int counter = 0;
		for(int i =0; i < board.length; i++){
			if(board[i] == 1){
				counter = counter + i + 1;
			}
		}
		return counter;
	}
	private static boolean canPlaceQueen(int[]board,int i){
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
