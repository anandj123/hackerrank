/*
ID: jain.121
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.Arrays;

class milk {
	
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f      = new BufferedReader(new FileReader("milk.in")); 
	  PrintWriter  out      = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
	  String input          = f.readLine().trim();
	  Integer amountToBuy   = Integer.parseInt(input.split(" ")[0]); 
	  Integer N             = Integer.parseInt(input.split(" ")[1]);
	  
	  int[][] milkPriceQty = new int[N][2];
	  
	  // Load data
	  for (int i=0; i<N; i++) {
		  String input1   = f.readLine().trim();
		  int price      = Integer.parseInt(input1.split(" ")[0]);
		  int qty        = Integer.parseInt(input1.split(" ")[1]);
		  milkPriceQty[i][0]  = price;
		  milkPriceQty[i][1]  = qty;
	  }
	  
	  //sort by start time
	  Arrays.sort(milkPriceQty, 
			  new java.util.Comparator<int[]>()
			  {
		          public int compare(int[]a,int[]b){
		              return a[0]-b[0];
		          }
	  		  });
	  
	  // Greedy search algorithm
	  Integer minPrice = 0;
	  for (int i=0;i<N;i++){
		  if (amountToBuy > 0){
			  if (amountToBuy > milkPriceQty[i][1]){
				  minPrice += milkPriceQty[i][0] * milkPriceQty[i][1];
				  amountToBuy = amountToBuy - milkPriceQty[i][1];
			  }
			  else {
				  minPrice += milkPriceQty[i][0] * amountToBuy;
				  amountToBuy = 0;
				  break;
			  }
		  }
	  }
	  
	  System.out.println(minPrice);
	  out.println(minPrice);

	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}