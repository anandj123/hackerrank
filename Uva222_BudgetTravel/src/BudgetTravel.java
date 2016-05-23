
public class BudgetTravel {
	public static double[][] data = {
		{475.6},	
		{11.9, 27.4, 14.98, 6},	
		{102.0, 99.9}, 	
		{220.0, 132.9}, 
		{256.3, 147.9}, 
		{275.0, 102.9},
		{277.6, 112.9},
		{381.8, 100.9}};
	
	public static double gallonsLeft = 0.0;
	public static double moneySpent = data[1][2] * 100;
	public static double minMoney = Double.MAX_VALUE;
	public static double totalMiles = 0.0;
	
	public static boolean[] gasFilledAt = {false, false, false, false, false, false};
	
	public static void main(String[] args) {
		gallonsLeft = data[1][0];
		System.out.println(drive(0));
	}
	
	public static double drive(int position){
		if (position >= data[1][3]){
			return 0.0;
		}
		
		double minMoney1 = Double.MAX_VALUE;
		
		//stop for gas
		if (needToStop(position)){
			double milesDriven = data[position+2][0]- totalMiles;
			double totalMiles1 = data[position+2][0];
		    double gallonsFilled = gallonsLeft - (milesDriven / data[1][1]);
		    double moneySpent1 = moneySpent + 200 + gallonsFilled * data[position + 2][1];
		    gasFilledAt[position] = true;
		    moneySpent1 = moneySpent1 + drive(position + 1);
		    minMoney1 = Math.min(minMoney,moneySpent1);
		} else { //don't stop for gas
			// Stop anyway
			double milesDriven = data[position+2][0]- totalMiles;
			double totalMiles1 = data[position+2][0];
		    double gallonsFilled = gallonsLeft - (milesDriven / data[1][1]);
		    double moneySpent1 = moneySpent + 200 + gallonsFilled * data[position + 2][1];
		    gasFilledAt[position] = true;
		    moneySpent1 = moneySpent1 + drive(position + 1);
		    minMoney1 = Math.min(minMoney,moneySpent1);
		    
		    //Go to next station without stopping.
		    gasFilledAt[position] = false;
		    moneySpent1 = moneySpent + drive(position + 1);
		    minMoney1 = Math.min(minMoney,moneySpent1);
		}
		
		return minMoney1;
	}
	
	public static boolean needToStop(int position){
		int gasFilledStationNumber = -1;
		for (int i = 5; i > -1; i-- ){
			if (gasFilledAt[i]){
				gasFilledStationNumber = i;
				break;
			}
		}
		
		if (gasFilledStationNumber != -1){
			//Does it have more than 1/2 tank & can reach next gas station/destination
			double gasLeft = data[1][0] - (data[position +2][0] - data[gasFilledStationNumber+2][0]) / (data[1][1]);
			if (gasLeft >= data[1][0]/2){
				double milesToNext = 0.0;
				//Can we reach the next place or destination
				if (position < 5){
					milesToNext = data[position + 3][0] - data[position + 2][0];
				} else {
					milesToNext = data[0][0] - data[position + 2][0]; 
				}
				
				if (gasLeft * data[1][1] >= milesToNext){
					return false;
				}
			}
		} else {
			//Does it have more than 1/2 tank & can reach next gas station/destination
			double gasLeft = data[1][0] - (data[position + 2][0]) / (data[1][1]);
			if (gasLeft >= data[1][0]/2){
				double milesToNext = 0.0;
				//Can we reach the next place or destination
				if (position < 5){
					milesToNext = data[position + 3][0] - data[position + 2][0];
				} else {
					milesToNext = data[0][0] - data[position + 2][0]; 
				}
				
				if (gasLeft * data[1][1] >= milesToNext){
					return false;
				}
			}
		}
		return true;
	}	
}
