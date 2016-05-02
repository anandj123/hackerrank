import java.util.LinkedList;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello world");
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		int level = 1;
		while (!queue.isEmpty()){
			System.out.println("level = " + level);
			int levelnodes = queue.size();
			for (int i=0;i<levelnodes; i++){
				Integer a = queue.remove();
				System.out.println("nodes = " + a);
				if (a==2){
					queue.add(3);
					queue.add(4);
					queue.add(5);
				}
				if (a==3){
					queue.add(4);
					queue.add(5);
					queue.add(6);
				}
				if (a==4){
					queue.add(5);
					queue.add(6);
					queue.add(7);
				}
			}
			level++;
			
			
		}
		
		

	}

}
