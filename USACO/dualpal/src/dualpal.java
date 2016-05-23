/*
ID: your_id_here
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
	private static int baseDigits = 20;
	private static int [][] baseMultiple = new int [9][baseDigits];

	private static boolean isDualPalindrome(int input){
		int counter = 0;
		for (int ii=0; ii<9;ii++){
			if (isPalindrome(convertBase(ii, input))){
				counter++;
			}
			
			// the number is palindrome in 2 bases
			if (counter == 2){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isPalindrome(String input){
		boolean retVal = true;
		for (int i=0; i<input.length();i++){
			if(input.charAt(i)!=input.charAt(input.length()-i-1)){
				retVal = false;
				break;
			}
		}
		return retVal;
	}
	
	private static String convertBase(int base, int input){
		String retVal = "";
		
		int index = 8;
		if (baseMultiple[base][index] < input){
			index = baseDigits;
		}
		
		for (int j=0; j<index;j++){
			int k = input / baseMultiple[base][index-j-1];
			input = input % baseMultiple[base][index-j-1];
			retVal = retVal + String.valueOf(k);
		}
		return retVal.replaceAll("^0+", "");
	}
	
	public static void main (String [] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in")); 
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
	    String[] input = f.readLine().split(" ");
	    Integer N = Integer.parseInt(input[0]);
	    Integer S = Integer.parseInt(input[1]);
	    
	    f.close();
	    for (int j=0;j<9;j++){
		    for (int i=0;i<baseDigits;i++){
		    	baseMultiple[j][i] = (int)Math.pow(j+2, i);
		    }
	    }
	    
	    int i = S+1;
	    int counter = 0;
	    while(true){
	    	if (isDualPalindrome(i)){
	    		counter++;
	    		out.println(i);
	    	}
	    	
	    	if (counter == N){
	    		break;
	    	}
	    	i++;
	    }
	    
		out.close();
		System.exit(0);
  }
}