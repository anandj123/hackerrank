/*
ID: jain.121
LANG: JAVA
TASK: hopscotch
 */

import java.io.*;

class hopscotch {
	public static int R, C, K;
	public static int[][] data;
	public static int[][] mem;
	public static int counter;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

		String headerString = f.readLine();
		
		R = Integer.parseInt(headerString.split(" ")[0]);
		C = Integer.parseInt(headerString.split(" ")[1]);
		K = Integer.parseInt(headerString.split(" ")[2]);
		data = new int[R][C];
		mem  = new int[R][C];
		
		for (int i=0;i<R;i++){
			String rowString = f.readLine();
			for (int j=0; j<C; j++){
				data[i][j] = Integer.parseInt(rowString.split(" ")[j]);
				mem[i][j]  = -1;
			}
		}
		
		counter = 0;
		calculateHopscotch(0, 0);
		System.out.println(mem[0][0]);
		out.println(mem[0][0]);
		out.close();
		f.close();
	}
	
	public static int calculateHopscotch(int row, int col){
		int counter1 = 0;
		
		if (row >= R ||
			col >= C ) {
			return 0;
		}
		
		if (row == R - 1 &&
			col == C -1) {
			return 1;
		}
		
		if (mem[row][col] > -1){
			return mem[row][col];
		}
		
		for (int i = row + 1; i< R; i++){
			for (int j = col + 1; j< C; j++){
				if (data[i][j] != data[row][col]) {
					int ret = calculateHopscotch(i, j);
					if (ret > -1) {
						counter1+= ret;
					}
				}
			}
		}
		
		mem[row][col] = counter1;
		
		return counter1;
	}
}
