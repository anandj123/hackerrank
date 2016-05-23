import java.lang.reflect.Array;
import java.util.Arrays;

public class DiskSpace {
	public int minDrives(int[] used, int[] total) {
		int totalUsed = 0;
		for(int i = 0; i< used.length; i++){
			totalUsed = totalUsed + used[i];
		}
		int counter = 1;
		Arrays.sort(total);
			for(int k = total.length-1; k>= 0; k--){
				if(totalUsed - total[k] > 0){
					counter++;
					totalUsed = totalUsed - total[k];
				}
				else{
					break;
				}
			}
		return counter;
	}
}
