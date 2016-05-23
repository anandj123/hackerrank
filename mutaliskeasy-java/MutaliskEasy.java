public class MutaliskEasy {
	int numberOfAttacks = Integer.MAX_VALUE;
	public int minimalAttacks(int[] x) {
		numberOfAttacks = Integer.MAX_VALUE;
		attack(x, 0);
		return numberOfAttacks;
	}
	
	private boolean attack(int[] x, int attackN){
		if (numberOfAttacks <= attackN){
			return false;
		}
		
		if (checkIfAllDestroyed(x, attackN)){
			return true;
		}
		
		int[] y = new int[x.length];
		
		// attack 0,1,2
		if (numberOfAttacks > attackN + 1){
			if (x.length>0){
				y[0] = x[0] - 9;
			}
			if (x.length > 1){
				y[1] = x[1] - 3;
			}
			if (x.length > 2){
				y[2] = x[2] - 1;
			}
			attack(y, attackN +1);
			
		} else {
			return false;
		}
		
		// attack 0,2,1
		if (numberOfAttacks > attackN + 1){
			if (x.length>0){
				y[0] = x[0] - 9;
			}
			if (x.length>1){
				y[1] = x[1] - 1;
			}
			if (x.length>2){
				y[2] = x[2] - 3;
			}
			attack(y, attackN +1);
		} else {
			return false;
		}
		
		// attack 1,0,2
		if (numberOfAttacks > attackN + 1){
			if (x.length>0){
				y[0] = x[0] - 3;
			}
			if (x.length>1){
				y[1] = x[1] - 9;
			}
			if (x.length>2){
				y[2] = x[2] - 1;
			}
			attack(y, attackN +1);
		} else {
			return false;
		}
		
		// attack 1,2,0
		if (numberOfAttacks > attackN + 1){
			if (x.length>0){
				y[0] = x[0] - 1;
			}
			if (x.length>1){
				y[1] = x[1] - 9;
			}
			if (x.length>2){
				y[2] = x[2] - 3;
			}
			attack(y, attackN +1);
		} else {
			return false;
		}
		
		// attack 2,0,1
		if (numberOfAttacks > attackN + 1){
			if (x.length>0){
				y[0] = x[0] - 3;
			}
			if (x.length>1){
				y[1] = x[1] - 1;
			}
			if (x.length>2){
				y[2] = x[2] - 9;
			}
			attack(y, attackN +1);
		} else {
			return false;
		}
		
		// attack 2,1,0
		if (numberOfAttacks > attackN + 1){
			if (x.length>0){
				y[0] = x[0] - 1;
			}
			if (x.length>1){
				y[1] = x[1] - 3;
			}
			if (x.length>2){
				y[2] = x[2] - 9;
			}
			attack(y, attackN +1);
		} else {
			return false;
		}
		return false;
		
	}
	private boolean checkIfAllDestroyed(int [] x, int attackN){
		switch(x.length){
			case 1:
				if (x[0] <= 0){
					if (attackN < numberOfAttacks){
						numberOfAttacks = attackN;
					}
					return true;
				}
			case 2:
				if (x[0] <= 0 && 
				    x[1] <= 0){
					if (attackN < numberOfAttacks){
						numberOfAttacks = attackN;
					}
					return true;
				}
			case 3:
				if (x[0] <= 0 && 
			    	x[1] <= 0 &&
			    	x[2] <= 0){
					if (attackN < numberOfAttacks){
						numberOfAttacks = attackN;
					}
					return true;
				}
		}
		return false;
	}

}
