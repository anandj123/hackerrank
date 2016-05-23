/*
ID: your_id_here
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
	private static int baseDigits = 12;
	private static Double [] baseMultiple = new Double [baseDigits];
	
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
	private static String convertBaseString(int input){
		if (input < 10){
			return String.valueOf(input);
		}
		else{
			char hex = (char) ('A' + input - 10);
			return String.valueOf(hex);
		}
	}
	
	private static String convertBase(int input){
		String retVal = "";
		for (int j=0; j<baseDigits;j++){
			int k = input / baseMultiple[baseDigits-j-1].intValue();
			input = input - k * baseMultiple[baseDigits-j-1].intValue();
			retVal = retVal + convertBaseString(k);
		}
		return retVal.replaceAll("^0+", "");
	}
	
	public static void main (String [] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in")); 
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
	    Integer base = Integer.parseInt(f.readLine());
	    f.close();
	    
	    for (int i=0;i<baseDigits;i++){
	    	baseMultiple[i] = Math.pow(base, i);
	    }
	    
	    for (int i=1; i<=300; i++) {
	    	int square = (int) Math.pow(i, 2);
	    	String squareBase = convertBase(square);
	    	String origBase   = convertBase(i);
	    	if (isPalindrome(squareBase)){
	    		System.out.println(origBase + " " + squareBase);
	    		out.println(origBase + " " + squareBase);
	    	}
	    }
		out.close();
		System.exit(0);
  }
}