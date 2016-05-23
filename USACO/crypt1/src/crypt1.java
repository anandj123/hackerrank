/*
ID: jain.121
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.Arrays;

class crypt1 {
  public static boolean isPrimeCrypt(int a, int b, int c, int d, int e){
	  boolean ans = false;
	  int mult1 = 100 * a + 10 * b + c;
	  
	  String firstLine = String.valueOf(mult1 * d);
	  String secondLine = String.valueOf(mult1 * e);
	  String finalLine  = String.valueOf((mult1 * (10 * d + e)));
	  
	  if (firstLine.length() == 3 &&
		  secondLine.length() == 3 &&
		  isInArray(firstLine) &&
		  isInArray(secondLine) &&
		  isInArray(finalLine)) {
		  ans = true;
	  }
	  
	  return ans;
  }
  
  public static boolean isInArray(String input){
	  boolean ans = true;
	  
	  for (int x=0;x<input.length();x++){
		  int thisChar = Integer.parseInt("" + input.charAt(x));
		  int contains = Arrays.binarySearch(crypt, thisChar);
		  if (contains<0) {
			  ans = false;
			  break;
		  }
	  }
	  return ans;
  }
  public static int[] crypt;
  
  public static void main (String [] args) throws IOException {
	  int result = 0;
	  BufferedReader f = new BufferedReader(new FileReader("crypt1.in")); 
	  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
	  Integer N        = Integer.parseInt(f.readLine().trim());
	  
	  crypt    = new int[N];
	  String input1  = f.readLine().trim();
	  // Load data
	  for (int i=0; i<N; i++) {
		  crypt[i]  = Integer.parseInt(input1.split(" ")[i]);
	  }
	  Arrays.sort(crypt);
	  
	  for (int i=0; i<N; i++){
		  for (int j=0; j<N; j++){
			  for (int k=0; k<N; k++){
				  for (int l=0; l<N; l++){
					  for (int m=0; m<N; m++){
						  if (isPrimeCrypt(crypt[i], crypt[j], crypt[k], crypt[l], crypt[m])){
							  result++;
						  }
					  }
				  }
			  }
		  }
	  }
	  out.println(result);
	  out.close();
	  f.close();
	  
  }
}