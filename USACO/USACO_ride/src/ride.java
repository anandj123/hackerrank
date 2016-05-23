/*
ID: jain.121
LANG: JAVA
TASK: ride
*/
import java.io.*;

class ride {
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f = new BufferedReader(new FileReader("ride.in")); 
	  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
	  String group = f.readLine();
	  String comet = f.readLine();
	  

	  System.out.println(group);
	  System.out.println(comet);
	  
	  Integer g1 = 1;
	  Integer g  = 0;

	  for (int i = 0; i<group.length(); i++) {
		  g = Character.getNumericValue(group.charAt(i)) - 
				  Character.getNumericValue('A') + 1;
		  g1 *= g;
		  System.out.println(" char " + g + " sum " + g1);
	  }
	  
	  int c1 = 1;
	  int c  = 0;
	  for (int i=0; i<comet.length(); i++) {
		  c = Character.getNumericValue(comet.charAt(i)) - 
				  Character.getNumericValue('A') + 1;
		  c1 *= c;
		  System.out.println(" char " + c + " sum " + c1);
	  }
	  
	  System.out.println(" char " + g + " sum " + g1 + " mod " + g1 % 47);
	  System.out.println(" char " + c + " sum " + c1 + " mod " + c1 % 47);
	  
	  // output result
	  if (g1 % 47 == c1 % 47) {
		  out.println("GO");                           
	  }
	  else
	  {
		  out.println("STAY");
	  }
	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}