
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,4,6,7,12,13,15,18,19,20,22,24};
		
		int search = 24;
		int start = 0;
		int end = input.length-1;
		
		while(true){
			if (start > end) {
				System.out.println("not found");
				break;
			}
			
			int mid = (int) Math.floor((start + end)/2);
			
			if (input[mid] > search) {
				end = mid - 1;
				continue;
			}
			
			if (input[mid] < search) {
				start = mid + 1;
				continue;
			}
			
			System.out.println("entry found at index = " + mid);
			break;
		}

	}

}
