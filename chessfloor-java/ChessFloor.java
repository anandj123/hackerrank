public class ChessFloor {

	public int minimumChanges(String[] floor) {
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < 26; j++){
				if(i != j ){
					ans = Math.min(ans, makeBoard((char)(i + 'a'), (char) (j + 'a'), floor));
				}
			}
		}
		return ans;
		
	}
	public static int makeBoard(char first , char second , String[] floor){
		int ans1 = 0;
		int ans2 = 0;
		char[][] newFloor1 = new char[floor.length][floor.length];
		newFloor1[0][0] = first;
		newFloor1[0][1] = second;
		char x1 = first;
		char x2 = second;
		
		for (int i=0; i<floor.length; i++){
			char y1 = x1;
			char y2 = x2;
			for (int j=0; j<floor.length; j++){
				if (floor[i].charAt(j) != y1){
					ans1++;
				} 
				
				// flip row characters
				if (y1 == x1){
					y1 = x2;
					y2 = x1;
				} else {
					y1 = x1;
					y2 = x2;
				}
			}
			
			// flip the first and second characters
			if (x1 == first){
				x1 = second;
				x2 = first;
			} else {
				x1 = first;
				x2 = second;
			}
			
		}
		
		x1 = second;
		x2 = first;
		
		for (int i=0; i<floor.length; i++){
			char y1 = x1;
			char y2 = x2;
			for (int j=0; j<floor.length; j++){
				if (floor[i].charAt(j) != y1){
					ans2++;
				} 
				
				// flip row characters
				if (y1 == x1){
					y1 = x2;
					y2 = x1;
				} else {
					y1 = x1;
					y2 = x2;
				}
			}
			// flip the first and second characters
			if (x1 == first){
				x1 = second;
				x2 = first;
			} else {
				x1 = first;
				x2 = second;
			}
			
		}
		return Math.min(ans1, ans2);
		
	}
	

}
