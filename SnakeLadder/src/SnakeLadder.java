import java.io.*;
import java.util.*;

public class SnakeLadder {
	public static int[] visited = new int[101];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("snake.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// Loop for each of the board
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, 0);
			int[][] adjmat = loadadjmat(f);

			int currpos = 1;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			int level = 1;
			for (int j = currpos + 1; j < 101; j++) {
				if (adjmat[currpos][j] == 1) {
					queue.add(j);
				}
			}
			boolean canReach = false;
			for (int j = 1; j < 101; j++) {

				if (adjmat[j][100] == 1) {
					canReach = true;
					break;
				}
			}
			if (!canReach) {
				System.out.println(-1);
				continue;
			}
			visited[currpos] = 1;
			// BFS with level order traversal
			while (!queue.isEmpty()) {
				
				if (currpos == 100) {
					queue.clear();
					break;
				}

				int levelnodes = queue.size();
				for (int j = 0; j < levelnodes; j++) {
					currpos = queue.remove();
					if (visited[currpos] == 1){
						continue;
					}
					visited[currpos] = 1;
					if (currpos == 100) {
						System.out.println(level);
						queue.clear();
						break;
					}
					for (int k = 1; k < 101; k++) {
						if (adjmat[currpos][k] == 1 &&
							visited[k] == 0) {
							queue.add(k);
						}
					}
				}
				level++;
			}
		}
	}

	private static int[][] loadadjmat(BufferedReader f) throws IOException {
		int[][] adjmat = new int[101][101];
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 7; j++) {
				if (i + j < 101) {
					adjmat[i][i + j] = 1;
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		
		for (int j = 0; j < N1; j++) {
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// connect the ladders
			for (int k = 1; k < 101; k++) {
				if (adjmat[k][start] == 1) {
					adjmat[k][start] = 0;
					adjmat[k][end] = 1;
				}
				adjmat[start][k] = 0;
				adjmat[start][end] = 1;
			}
		}

		st = new StringTokenizer(f.readLine());
		int N2 = Integer.parseInt(st.nextToken());
		
		for (int j = 0; j < N2; j++) {
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// connect the snakes
			for (int k = 1; k < 101; k++) {
				if (adjmat[k][start] == 1) {
					adjmat[k][start] = 0;
					adjmat[k][end] = 1;
				}
				adjmat[start][k] = 0;
				adjmat[start][end] = 1;
			}
		}
		return adjmat;
	}
}
