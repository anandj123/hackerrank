
public class Target {

	public String[] draw(int n) {
		String[] retVal = new String[n];
		int inLoopNumber = 0;
		boolean halfway = false;
		for (int i=0;i<n; i++){
			
			//First and last rows
			if (i==0 ||
				i==n-1){
				retVal[i]=new String(new char[n]).replace('\0', '#');
				System.out.println(retVal[i]);
				inLoopNumber++;
				continue;
			}
			
			//Middle  row
			boolean spaceMarker = false; 
			if (i == n/2){
				retVal[i] = "";
				for (int j=0; j<n; j++){
					if (spaceMarker){
						retVal[i] += " ";
						
					} else {
						retVal[i] += "#";
					}
					spaceMarker = !spaceMarker;
				}
				System.out.println(retVal[i]);
				halfway = true;
				continue;
			}
			
			// Odd rows
			if (i%2 >0){
				retVal[i]="";
				for (int j=0;j<inLoopNumber; j++){
					retVal[i] += "# ";
				}
				for (int j=inLoopNumber*2; j<n-(2*inLoopNumber); j++){
					retVal[i] += " ";
				}
				for (int j=0;j<inLoopNumber; j++){
					retVal[i] += " #";
				}
				System.out.println(retVal[i]);
				continue;
			}
			
			// even rows
			if (i%2 == 0){
				retVal[i]="";
				for (int j=0;j<inLoopNumber; j++){
					retVal[i] += "# ";
				}
				for (int j=inLoopNumber*2; j<n-(2*inLoopNumber); j++){
					retVal[i] += "#";
				}
				for (int j=0;j<inLoopNumber; j++){
					retVal[i] += " #";
				}
				System.out.println(retVal[i]);
				if (!halfway) {
					inLoopNumber++;
				} else {
					inLoopNumber--;
				}
				
				continue;
			}
			
		}
		return null;
	}

}
