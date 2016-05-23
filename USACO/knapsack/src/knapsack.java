import java.io.*;

class knapsack {
	public static int [] weights = {11, 8, 7, 6, 5};
	public static int [] values  = {11, 8, 7, 6, 5};
	public static int capacity   = 20;
	
	public static void main(String[] args) throws IOException {
		int retVal = knapsackval(0, capacity);
		System.out.println(retVal);
	}
	public static int knapsackval(int index, int cap){
		System.out.println("called with parameters index " + index + " capacity " + cap );
		
		//if it's the end of the list then see if we can add it to our kanpsack else return 0;
		if (index == weights.length-1){
			if (cap >= weights[index]) { 
				return values[index]; 
			}
			else { 
				return 0; 
			}
		}
		
		int retVal = 0;
		
		if (weights[index]>cap){
			// if the current weight is more than capacity left then just search without this entry.
			retVal = knapsackval(index+1, cap);
		}
		else {
			// else we need to find the maximum value considering the current entry (take it in kanpsack so reducing the capacity left)
			// Vs. not considering the current entry. 
			retVal = Math.max(knapsackval(index+1, cap), values[index] + knapsackval(index+1, cap-weights[index]));
		}
		System.out.println("retVal = " + retVal);
		return retVal;
	}
}
