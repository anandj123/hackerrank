/*
ID: jain.121
LANG: JAVA
TASK: beads
*/
import java.io.*;

class beads {
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f = new BufferedReader(new FileReader("beads.in")); 
	  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
	  
	  String N = f.readLine();
	  String beads = f.readLine();
	  
	  System.out.println(N);
	  System.out.println(beads);
	  
	  int totBeads = 0;
	  for (int i=0; i<beads.length(); i++){
		  if (beads.charAt(i) == 'w') {
			  continue;
		  }
		  
		  String newBeads = "";
		  newBeads = beads.substring(i) + beads.substring(0, i);
		  
		  int fwd = 0;
		  int rev = 0;
		  int j = 0;
		  for (j=0;j<newBeads.length(); j++){
			  if ((newBeads.charAt(j) == newBeads.charAt(0)) || 
					  (newBeads.charAt(j) == 'w')) {
				  fwd ++;
			  }
			  else { break; }
		  }
		  
		  char revChar = 0;
		  for (int k=newBeads.length()-1;k>j; k--){
			  if ((newBeads.charAt(k) != 'w')) {
				  revChar = newBeads.charAt(k);
				  break;
			  }
		  }
		  for (int k=newBeads.length()-1;k>=j; k--){
			  
			  if ((newBeads.charAt(k) == revChar) || 
					  (newBeads.charAt(k) == 'w')) {
				  rev ++;
			  }
			  else { break; }
		  }
		  
		  if (totBeads < fwd + rev) {
			  totBeads = fwd + rev;
			  System.out.println(newBeads);
		  }
	  }
	  
	  if (totBeads == 0) {
		  totBeads = beads.length();
	  }
	  
	  System.out.println(totBeads);
	  out.println(totBeads);
	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}