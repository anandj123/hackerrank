import java.util.Arrays;

class mergesort{
	public static int [] input = {5, 3, 6, 2, 8, 1};
	public static int [] temp;
	
	public static void main (String[] args){
		temp = sort(input);
		System.out.println(Arrays.toString(temp));
		
	}
	
	public static int[] sort(int[] s){
		if (s.length <= 1){
			return s;
		}
		
		int mid = s.length/2;
		
		
		int [] left = sort(Arrays.copyOfRange(s, 0, mid));
		int [] right = sort(Arrays.copyOfRange(s, mid, s.length));
		
		return merge(left, right);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int [] retVal = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(true){
			if (i>=left.length){
				if (j>=right.length){
					break;
				} else {
					retVal[k] = right[j];
					j++;
					k++;
					continue;
				}
			} 
			
			if (j>=right.length){
				if (i>=left.length){
					break;
				} else {
					retVal[k] = left[i];
					i++;
					k++;
					continue;
				}
			}
			
			if (left[i] <= right[j]){
				retVal[k] = left[i];
				i++;
				k++;
				continue;
			} else {
				retVal[k] = right[j];
				j++;
				k++;
			}
		}
		return retVal;
	}
}