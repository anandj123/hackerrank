/*
ID: your_id_here
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
  public static void main (String [] args) throws IOException {
	  // Use BufferedReader rather than RandomAccessFile; it's much faster
	  // input file name goes above
	  //System.out.println(new File(".").getAbsoluteFile());
	  //File file=new File("bin\\test.in");
	  //System.out.println(file.exists()); 
	  
	  BufferedReader f = new BufferedReader(new FileReader("bin\\test.in")); 

	  PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter("bin\\test.out")));
	  // Use StringTokenizer Vs readLine/split -- lots faster
	  StringTokenizer st = new StringTokenizer(f.readLine()); // Get line, break into tokens
	  int i1 = Integer.parseInt(st.nextToken());    // first integer
	  int i2 = Integer.parseInt(st.nextToken());    // second integer
	  out.println(i1+i2);                           // output result
	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
	  System.out.println("Hello");
  }
}
