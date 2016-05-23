/*
ID: jain.121
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.Arrays;

class gift1 {
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f = new BufferedReader(new FileReader("gift1.in")); 
	  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	  Integer N = Integer.parseInt(f.readLine());
	  String names[] = new String[N];
	  
	  for (int i=0; i<N; i++){
		  names[i] = f.readLine();
	  }
	  
	  Integer initialAmount [] = new Integer[N];
	  Integer finalAmount [] = new Integer[N];
	  Arrays.fill(initialAmount, new Integer(0));
	  Arrays.fill(finalAmount, new Integer(0));
	  
	  for (int i=0; i<N; i++){
		  String giftgiver = f.readLine();
		  
		  int index = Arrays.asList(names).indexOf(giftgiver);
		  String giftInstruction = f.readLine();
		  int initAmount = Integer.parseInt(giftInstruction.split(" ")[0]);
		  int NReceiver = Integer.parseInt(giftInstruction.split(" ")[1]);
		  
		  if (NReceiver > 0) {
			  initialAmount[index] 	= initAmount;
			  int distAmount 		= initAmount/NReceiver;
			  finalAmount[index]   += initAmount - distAmount * NReceiver;
			  
			  for (int j=0;j<NReceiver;j++){
				  String receiver = f.readLine();
				  int index1 = Arrays.asList(names).indexOf(receiver);
				  finalAmount[index1] += distAmount;
			  }
		  }
	  }
	  
	  for (int i=0; i<N; i++){
		  String output = names[i] + " " + Integer.toString((finalAmount[i] - initialAmount[i]));
		  System.out.println(output);
		  out.println(output);
	  }
	  
	  
	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}