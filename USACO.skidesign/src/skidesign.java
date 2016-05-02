/*
ID: jain.121
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

public class skidesign {
	private static int N;
	private static int[] X;
	public static void main(String[] args) throws IOException {

		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		X = new int[N];
		
		for (int i=0; i<N; i++){
			st = new StringTokenizer(f.readLine());
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		out.println(solve());
		f.close();
		out.close();
	}
	
	private static int solve(){
		int retVal = Integer.MAX_VALUE, maxHill = 0;
		for (int i=0;i<N;i++){
			if (X[i] > maxHill){
				maxHill = X[i];
			}
		}
		
		for(int i=0;i<maxHill-17+1;i++){
			int cost = 0;
			for (int j=0;j<N;j++){
				if (X[j] < i) {
					cost+=Math.pow(i-X[j], 2);
				}
				if (X[j] > i+17){
					cost += Math.pow(X[j]-i-17, 2);
				}
			}
				
			if (cost < retVal){
				retVal = cost;
			}
			
		}
		System.out.println(retVal);
		return retVal;
	}
}
