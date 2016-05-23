public class PublicTransit {

	public int minimumLongestDistance(int R, int C) {
		int minDist = Integer.MAX_VALUE;
		
		
		for (int startTeleX=0; startTeleX<R; startTeleX++){
			for (int startTeleY=0; startTeleY<C; startTeleY++){
				
				for (int endTeleX=0; endTeleX<R; endTeleX++){
					for (int endTeleY=0; endTeleY<C; endTeleY++){
						int dist = findMaxDist(startTeleX, startTeleY, endTeleX, endTeleY, R, C);
						if (dist < minDist){
							minDist = dist;
						}
						
					}
				}
						
			}
		}
		
		return minDist;
	}
	
	private int findMaxDist(int startTeleX, int startTeleY, int endTeleX, int endTeleY, int R, int C){
		int maxDist = 0;
		//System.out.println("Teleporters start pos (" + startTeleX + ", " + startTeleY + ") Teleporter end pos ("+ endTeleX + ", " + endTeleY + ")");
		// start position
		for (int startX=0; startX<R; startX++){
			for (int startY=0; startY<C; startY++){
				// end position
				for (int endX=0; endX<R; endX++){
					for (int endY=0; endY<C; endY++){
						int dist = calcDist(startX, startY, endX, endY, startTeleX, startTeleY, endTeleX, endTeleY);
						//System.out.println("start pos (" + startX + ", " + startY + ") end pos ("+ endX + ", " + endY + ") distance = " + dist);
						if (dist > maxDist){
							maxDist = dist;
						}
						
					}
				}
				
			}
		}
		//System.out.println("max distance = " + maxDist);
		return maxDist;
	}
	private int calcDist(int startX, int startY, int endX, int endY, int startTeleX, int startTeleY, int endTeleX, int endTeleY){
		int retVal = 0;
		int directDist = Math.abs(endX - startX) + Math.abs(endY - startY);
		int tel1Dist = Math.abs(startX - startTeleX) + Math.abs(startY - startTeleY) + Math.abs(endTeleX - endX) + Math.abs(endTeleY - endY);
		int tel2Dist = Math.abs(startX - endTeleX) + Math.abs(startY - endTeleY) + Math.abs(startTeleX - endX) + Math.abs(startTeleY - endY);
		retVal = Math.min(tel2Dist, Math.min(directDist, tel1Dist));
		return retVal;
	}

}
