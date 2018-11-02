package USACO.barn1.src;/*
ID: jain.121
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.Arrays;

class barn1 {
	
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f      = new BufferedReader(new FileReader("barn1.in")); 
	  PrintWriter  out      = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
	  String input          = f.readLine().trim();
	  Integer totalBoards   = Integer.parseInt(input.split(" ")[0]); 
	  Integer totalStalls   = Integer.parseInt(input.split(" ")[1]);
	  Integer N             = Integer.parseInt(input.split(" ")[2]);
	  
	  int[][] cowStalls = new int[N][2];
	  
	  // Load data
	  for (int i=0; i<N; i++) {
		  String input1       = f.readLine().trim();
		  int stall           = Integer.parseInt(input1.split(" ")[0]);
		  cowStalls[i][0]     = stall;
	  }
	  
	//sort again to original 
	  Arrays.sort(cowStalls, 
			  new java.util.Comparator<int[]>()
			  {
		          public int compare(int[]a,int[]b){
		              return a[0]-b[0];
		          }
	  		  });
	  
	  for (int i=0; i<N; i++) {
		  if (i==0){
			  cowStalls[i][1] = 0;
		  }
		  else {
			  cowStalls[i][1]     = cowStalls[i][0] - cowStalls[i-1][0];
		  }
	  }
	  
	  //sort by max distance from high to low
	  Arrays.sort(cowStalls, 
			  new java.util.Comparator<int[]>()
			  {
		          public int compare(int[]a,int[]b){
		              return b[1]-a[1];
		          }
	  		  });
	  
	  for (int i=0; i<N; i++) {
		  if (i<totalBoards-1){
			  cowStalls[i][1]     = 1;
		  }
		  else {
			  cowStalls[i][1]     = 0;
		  }
			  
	  }
	  
	  //sort again to original 
	  Arrays.sort(cowStalls, 
			  new java.util.Comparator<int[]>()
			  {
		          public int compare(int[]a,int[]b){
		              return a[0]-b[0];
		          }
	  		  });

	  
	  // Greedy search algorithm
	  Integer minStalls = 0;
	  Integer start = cowStalls[0][0];
	  for (int i=1;i<N;i++){
		  if (cowStalls[i][1] == 1){
			  minStalls = minStalls + (cowStalls[i-1][0] - start) + 1;
			  start = cowStalls[i][0];
		  }
	  }
	  
	  if (cowStalls[N-1][0] != start){
		  minStalls = minStalls + (cowStalls[N-1][0] - start) + 1;
	  }
	  else
	  {
		  minStalls++;
	  }
	  
	  System.out.println(minStalls);
	  out.println(minStalls);

	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}