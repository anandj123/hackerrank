/*
ID: jain.121
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.Arrays;

class transform {
	public static boolean matchPattern1(char[][] input, char[][] output){
		  int N = input.length;
		  char[][] retVal = rotate90(input);
		  
		  boolean same = true;
		  for (int i=0; i<N; i++){
			  same = same & Arrays.equals(retVal[i], output[i]);
			  
		  }
		  
		  if (same) {
			  System.out.println("1");
		  }
		  return same;
	  }
	
	  public static boolean matchPattern2(char[][] input, char[][] output){
		  int N = input.length;
		  char[][] retVal = rotate90(input);
		  retVal = rotate90(retVal);
		  
		  boolean same = true;
		  for (int i=0; i<N; i++){
			  same = same & Arrays.equals(retVal[i], output[i]);
			  
		  }
		  if (same) {
			  System.out.println("2");
		  }
		  return same;
	  }
	  
	  public static boolean matchPattern3(char[][] input, char[][] output){
		  int N = input.length;
		  char[][] retVal = rotate90(input);
		  retVal = rotate90(retVal);
		  retVal = rotate90(retVal);
		  
		  boolean same = true;
		  for (int i=0; i<N; i++){
			  same = same & Arrays.equals(retVal[i], output[i]);
			  
		  }
		  if (same) {
			  System.out.println("2");
		  }
		  return same;
	  }
	  public static boolean matchPattern4(char[][] input, char[][] output){
		  int N = input.length;
		  char[][] retVal = reflection(input);
		  
		  boolean same = true;
		  for (int i=0; i<N; i++){
			  same = same & Arrays.equals(retVal[i], output[i]);
			  
		  }
		  if (same) {
			  System.out.println("2");
		  }
		  return same;
	  }
	  public static boolean matchPattern5(char[][] input, char[][] output){
		  int N = input.length;
		  char[][] retVal = reflection(input);
		  
		  boolean same = true;
		  for (int j=0;j<3;j++){
			  same = true;
			  retVal = rotate90(retVal);
			  for (int i=0; i<N; i++){
				  same = same & Arrays.equals(retVal[i], output[i]);
			  }
			  if (same) {
				  System.out.println("5");
				  break;
			  }
		  }
		  return same;
	  }
	  public static boolean matchPattern6(char[][] input, char[][] output){
		  int N = input.length;
		  boolean same = true;
		  
		  for (int i=0; i<N; i++){
			  same = same & Arrays.equals(input[i], output[i]);
		  }
			
		  return same;
	  }
	  public static char[][] rotate90(char[][] input){
		  int N = input.length;
		  char[][] retVal = new char[N][N];
		  for (int i=0; i<N; i++){
			  for (int j=0; j<N; j++){
				  retVal[i][j] = input[N-j-1][i];
			  }
		  }
		  return retVal;
	  }
	  public static char[][] reflection(char[][] input){
		  int N = input.length;
		  char[][] retVal = new char[N][N];
		  for (int i=0; i<N; i++){
			  for (int j=0; j<N; j++){
				  retVal[i][j] = input[i][N-j-1];
			  }
		  }
		  return retVal;
	  }
  
	  public static void main (String [] args) throws IOException {
		  BufferedReader f = new BufferedReader(new FileReader("transform.in")); 
		  PrintWriter  out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		  Integer N        = Integer.parseInt(f.readLine().trim());
	  
		  char[][] patternIn  = new char[N][N];
		  char[][] patternOut = new char[N][N];
		  
		  // Load data
		  for (int i=0; i<N; i++) {
			  String input   = f.readLine().trim();
			  for (int j=0; j<N; j++) {
				  patternIn[i][j] = input.charAt(j);
			  }
		  }
		  for (int i=0; i<N; i++){
			  String input   = f.readLine().trim();
			  for (int j=0; j<N; j++) {
				  patternOut[i][j] = input.charAt(j);
			  }
		  }
		  
		  if (matchPattern1(patternIn, patternOut)){
			  out.println("1");
		  }
		  else if (matchPattern2(patternIn, patternOut)) {
			  out.println("2");
		  }
		  else if (matchPattern3(patternIn, patternOut)) {
			  out.println("3");
		  }
		  else if (matchPattern4(patternIn, patternOut)) {
			  out.println("4");
		  }
		  else if (matchPattern5(patternIn, patternOut)) {
			  out.println("5");
		  }
		  else if (matchPattern6(patternIn, patternOut)) {
			  out.println("6");
		  }
		  else {
			  out.println("7");
		  }
		  out.close();                                  // close the output file
		  f.close();
		  System.exit(0);                               // don't omit this!
	  }
}