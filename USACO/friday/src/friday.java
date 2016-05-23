/*
ID: jain.121
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.Arrays;

class friday {
	public static Boolean isLeap(int year) {
		if (year % 100 == 0 && year % 400 == 0) { 
			return true;
		}
		else if (year % 100 != 0 && year % 4 == 0) { 
			return true;
		} 
		else { 
			return false; 
		}
	}
	
  public static void main (String [] args) throws IOException {
	  
	  BufferedReader f = new BufferedReader(new FileReader("friday.in")); 
	  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
	  Integer N = Integer.parseInt(f.readLine());
	  
	  int daysInMonthNormal[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	  int daysInMonthLeap[]   = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	  
	  int output [] = {0,0,0,0,0,0,0};
	  
	  int startDay = 2 ;  // array starts from Saturday and 1/1/1900 is Monday
	  
	  for (int i = 0; i < N; i++) {
		  int year = 1900 + i;
		  int [] daysArray = null;
		  if (isLeap(year))
		  {
			  daysArray  = daysInMonthLeap;
			  
		  }
		  else
		  {
			  daysArray = daysInMonthNormal;
		  }
		  
		  for (int j=0; j<12; j++) {
			  for (int k = 0; k<daysArray[j]; k++){
				  
				  if (startDay == 7){
					  startDay = 0;
				  }
				  
				  // If the date is 13th (0 based index)
				  if (k==12) {
					  output[startDay] +=1;
				  }
				  startDay ++;
			  }
		  }
	  }
	  out.println(output[0] + " " + 
			  		output[1] + " " + 
			  		output[2] + " " + 
			  		output[3] + " "+ 
			  		output[4] + " "+ 
			  		output[5] + " "+ 
			  		output[6]);
	  
	  System.out.println(output[0] + " " + 
		  		output[1] + " " + 
		  		output[2] + " " + 
		  		output[3] + " "+ 
		  		output[4] + " "+ 
		  		output[5] + " "+ 
		  		output[6] + " ");

	  out.close();                                  // close the output file
	  f.close();
	  System.exit(0);                               // don't omit this!
  }
}