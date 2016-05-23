/*
ID: your_id_here
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
	
	private static List<String> dict1 = new ArrayList<String>();
	private static String[] dict2     = null;
	private static Integer[][] dict2Index   = new Integer[26][26];
	private static String [] touchTone = {"ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};
	private static ArrayList<String> a1    = new ArrayList<String>();
	
	private static String checkDict(String input){
		String retVal = "";
		//String []dict3 = dict2[input.charAt(0) - 'A'].clone();
		int index1 = input.charAt(0) - 'A';
		int index2 = input.charAt(1) - 'A';
		
		if (dict2Index[index1][index2] != null){
			for(int i=dict2Index[index1][index2];i<dict2.length; i++){
				String dictVal = dict2[i];
				if(dictVal.substring(0,2).compareTo(input.substring(0, 2)) > 0){
					break;
				}
				if(dictVal.equals(input)) {
					//System.out.println(input);
					return input;
				}
			}
		}
		return retVal;		
	}
	
	private static boolean isPresent(String input) {
		int index1 = input.charAt(0) - 'A';
		int index2 = input.charAt(1) - 'A';
		
		if (dict2Index[index1][index2] == null){
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main (String [] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("namenum.in")); 
		PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
	    String input = f.readLine();
	    f.close();
	    
	    // Load dictionary
	    BufferedReader f1 = new BufferedReader(new FileReader("dict.txt")); 

		String dictentry;
		int len = input.length();
		while((dictentry = f1.readLine()) != null) {
			if (dictentry.length() == len) {
				dict1.add(dictentry);
			}
		}
		
		// Because of 1sec run time limit we need to do optimization
		// so maintain the dict in an array and keep starting index of first 2 characters
		dict2 = new String[dict1.size()];
		for (int i=0; i<dict1.size(); i++){
			String entry = dict1.get(i);
			int index1 = entry.charAt(0) - 'A';
			int index2 = entry.charAt(1) - 'A';
			  
			dict2[i] = entry;
			if (dict2Index[index1][index2] == null) {
				dict2Index[index1][index2] = i;
			}
		}
		dict1 = null;
		f1.close();
	  
	    //Initialize the array with the first character
	    String s1 = touchTone[Integer.parseInt(String.valueOf(input.charAt(0))) - 2];
	    for (int i=0;i<s1.length(); i++){
		  a1.add(String.valueOf(s1.charAt(i)));
	    }
	    
	    //Load the rest of the possible combinations
	    ArrayList<String> a2 = new ArrayList<String>();
	    for (int i=1;i<input.length();i++){
		  s1 = touchTone[Integer.parseInt(String.valueOf(input.charAt(i))) - 2];
		  for(int j=0;j<a1.size(); j++){
			  for (int k=0; k<s1.length(); k++){
				  String putString = a1.get(j)+s1.charAt(k);
				  if (isPresent(putString))
				  {
					  a2.add(putString);
				  }
			  }
		  }
		  a1.clear();
		  a1.addAll(a2);
		  a2.clear();
	    }
    
		boolean nameFound = false;
		for (int i=0; i<a1.size();i++){
			String s2 = checkDict(a1.get(i));
			//String s2 = "FOO";
			if (s2 != ""){
				nameFound = true;
				out.println(s2);
			}
		}
		  
		if(!nameFound){
			out.println("NONE");
		}
		
		out.close();
		System.exit(0);
  }
}