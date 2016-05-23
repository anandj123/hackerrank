/*
ID: jain.121
LANG: JAVA
TASK: combo
 */
import java.io.*;
import java.util.ArrayList;

class combo {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

		int N = Integer.parseInt(f.readLine());
		String johnString = f.readLine();
		String masterString = f.readLine();
		
		int[] johnKeys = {Integer.parseInt(johnString.split(" ")[0]),
				Integer.parseInt(johnString.split(" ")[1]),
				Integer.parseInt(johnString.split(" ")[2])};
		int[] masterKeys = {Integer.parseInt(masterString.split(" ")[0]),
				Integer.parseInt(masterString.split(" ")[1]),
				Integer.parseInt(masterString.split(" ")[2])};
		
		int counter=0;
		
		ArrayList<Integer> m1 = new ArrayList<Integer>();
		for (int i = johnKeys[0]-2; i<= johnKeys[0]+2;i++){
			Integer ci = circularIndexCalc(i, N);
			if (!m1.contains(ci)) {
				m1.add(ci);
			}
		}
		
		ArrayList<Integer> m2 = new ArrayList<Integer>();
		for (int i=johnKeys[1]-2;i<=johnKeys[1]+2;i++){
			Integer ci = circularIndexCalc(i, N);
			if (!m2.contains(ci)) {
				m2.add(ci);
			}
		}
		
		ArrayList<Integer> m3 = new ArrayList<Integer>();
		for(int i=johnKeys[2]-2;i<=johnKeys[2]+2;i++){
			Integer ci = circularIndexCalc(i, N);
			if (!m3.contains(ci)) {
				m3.add(ci);
			}
		}
		
		counter = m1.size() * m2.size() * m3.size();
		
		for (int i = masterKeys[0]-2; i<= masterKeys[0]+2;i++){
			for (int j=masterKeys[1]-2;j<=masterKeys[1]+2;j++){
				for(int k=masterKeys[2]-2;k<=masterKeys[2]+2;k++){
					int ci1 = circularIndexCalc(i, N);
					int ci2 = circularIndexCalc(j, N);
					int ci3 = circularIndexCalc(k, N);
					if (m1.contains(ci1) &&
						m2.contains(ci2) &&
						m3.contains(ci3)) {
						continue;
					} else {
						counter++;
					}
				}
			}
		}
		
		System.out.println(counter);
		
		out.println(counter);
		
		out.close();
		f.close();
	}
	
	public static Integer circularIndexCalc(int index, int maxEntries){
		Integer retVal = index;
		if (retVal>=1){
			while (retVal > maxEntries){
				retVal -= maxEntries;
			}
		} else {
			while (retVal <= 0){
				retVal += maxEntries;
			}
		}
		return retVal;
	}
}
