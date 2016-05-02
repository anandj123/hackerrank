/*
ID: jain.121
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

public class wormhole {
	private static int N;
	private static long[] X, Y, link, next;
	
	public static void main(String[] args) throws IOException {

		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		X = new long[N];
		Y = new long[N];
		link = new long[N];
		Arrays.fill(link, -1);
		next = new long[N];
		Arrays.fill(next, -1);
		
		for (int i=0; i<N; i++){
			st = new StringTokenizer(f.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				
				if (Y[j] == Y[i] && 
					X[j] >  X[i]){
					if (next[i] == -1){
						next[i] = j;
					}
					if (X[j] < X[(int) next[i]]){ //if another wormhole is closer to original then use that
						next[i] = j;
					}
					
				}
			}
		}
		
		out.println(solve());
		
		f.close();
		out.close();
	}
	
	public static int checkCycle(){
		long[] cycle = new long[N];
		
		for (int i=0;i<N;i++){
			long j=i;
			Arrays.fill(cycle, -1);
			while(true){
				if (j==-1){
					break; // fell off the grid so no cycle so check the next start node
				}
				if (cycle[(int) j] == 1){
					return 1; //cycle found
				}
				cycle[(int) j]=1;
				j = link[(int) j];
				j = next[(int) j];
				
			}
		}
		return 0;
	}
	
	public static int solve(){
		int retVal = 0;
		
		//Check if all the warmholes are connected
		boolean allConnected = true;
		for (int i=0; i<N; i++){
			if (link[i]==-1){
				allConnected = false;
				break;
			}
		}
		if (allConnected){
//			System.out.println("All warmholes connected" +Arrays.toString(link));
			return checkCycle();
		}
		
		for (int i=0;i<N;i++){
			if (link[i] == -1){
				for (int j=i+1;j<N;j++){
					if (link[j]==-1){
						link[i] = j;
						link[j] = i;
						retVal += solve();
						link[i] = -1;
						link[j] = -1;
						
					}
				}
				break;
			}
		}
//		System.out.println("return value " + retVal);
		return retVal;
	}

}
