/*
ID: jain.121
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.Arrays;

class milk2 {
	
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f = new BufferedReader(new FileReader("milk2.in")); 
	  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
	  Integer N        = Integer.parseInt(f.readLine().trim());
	  
	  int[][] milking = new int[N][2];
	  
	  // Load data
	  for (int i=0; i<N; i++) {
		  String input   = f.readLine().trim();
		  int start      = Integer.parseInt(input.split(" ")[0]);
		  int end        = Integer.parseInt(input.split(" ")[1]);
		  milking[i][0]  = start;
		  milking[i][1]  = end;
	  }
	  
	  //sort by start time
	  Arrays.sort(milking, 
			  new java.util.Comparator<int[]>()
			  {
		          public int compare(int[]a,int[]b){
		              return a[0]-b[0];
		          }
	  		  });
	  
	  int milkGap   = 0;
	  int milkTime  = milking[0][1] - milking[0][0];
	  int timeEnd   = milking[0][1];
	  int timeStart = milking[0][0];
	  
	  for (int i=0; i<N; i++) {
		  int start1 = milking[i][0];
		  int end1   = milking[i][1];
		  
		// Overlapping
		  if (start1 <= timeEnd && end1 >= timeEnd) {             
			  if (end1 - timeStart > milkTime) {
				  milkTime    = end1 - timeStart;
			  }
			  timeEnd     = end1;
		  }
		  
		// Non overlapping
		  if (start1 > timeEnd) {             
			  timeStart = start1;
			  if (start1 - timeEnd > milkGap) {
				  milkGap   = start1 - timeEnd;
			  }
			  timeEnd = end1;
			  
		  }
		  
		// milking length check
		  if (end1 - start1 > milkTime) {     
			  milkTime    = end1 - start1;
			  timeEnd    = end1;
			  timeStart   = start1;
		  }
	  }
	  
	  System.out.println(milkTime + " " + milkGap);
	  out.println(milkTime + " " + milkGap);

	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}