public class Containers {
	public int wastedSpace(int[] containers, int[] packages) {
		int wasted = 0;
		for(int c = 0; c < packages.length; c++){
			if(containers[c] >= packages [c]){
				wasted = wasted + (containers[c] - packages [c]);
				containers[c] = 0;
			}
			else{
				for(int i = c; i< containers.length; i++){
					if(containers[i] >= packages [c]){
						wasted = wasted + (containers[i] - packages[c]);
					}
					wasted = wasted + containers[i];
				}
			}
		}
		return wasted;
	}

}
