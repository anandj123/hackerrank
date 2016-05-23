import java.util.BitSet;

public class ApplesAndOrangesHard {

	public int maximumApples(int N, int K, int[] info) {
		BitSet applePositions = new BitSet();
		//fixed apple positions
		for (int i=0; i<info.length; i++){
			applePositions.set(info[i]-1);
		}
		
		for (int i=0; i<N; i++){
			if(isFixedApplePosition(info, i)){
				continue;
			}
			applePositions.set(i);
			if (!isValid(applePositions, K, N, i)){
				applePositions.clear(i);
			}
		}
		
		return countApples(applePositions, N);
	}
	
	private boolean isValid(BitSet applePositions, int K, int N, int i){
		
		boolean retVal = true;
		int numberOfAppleInList = K/2;
		
		for (int j=i; j<N; j++){
			
			int numberOfApples = 0;
			int counter = 1;
			// Check last K positions and count number of apples
			for (int j1=j; j1>=0; j1--){
				
				if (applePositions.get(j1)){
					numberOfApples++;
				}
				
				if (counter == K){
					break;
				}
				counter++;
			}
			if (numberOfApples > numberOfAppleInList ){
				retVal = false;
				break;
			}
			
		}
		return retVal;
		
	}
	
	
	private boolean isFixedApplePosition(int[] info, int i){
		boolean retVal = false;
		for (int infoPosition= 0; infoPosition<info.length; infoPosition++){
			if (i == info[infoPosition]-1){
				retVal = true;
				break;
			}
		}
		return retVal;
	}
	private int countApples(BitSet applePositions, int N){
		int retVal = 0;
		for (int appleCount=0; appleCount<N; appleCount++){
			if (applePositions.get(appleCount)){
				retVal++;
			}
		}
		return retVal;
	}

}
