public class GridGenerator {

	public int generate(int[] row, int[] col) {
	int[][] fillGrid = new int[row.length][row.length];
	
	//fill top row//
	for(int i =0; i<row.length; i++){
		fillGrid[i][0] = row[i];
	}
	//fill left column//
	for(int i = 1; i< col.length; i++){
		fillGrid[0][i] = col[i];
	}
	for(int r =1; r <row.length; r++){
		for(int c =1; c < col.length; c++){
			fillGrid[r][c] = fillGrid[r-1][c-1] + fillGrid[r][c-1] + fillGrid[r-1][c];
		}
	}
	
	return fillGrid[row.length - 1][col.length - 1];
	}
	

}
