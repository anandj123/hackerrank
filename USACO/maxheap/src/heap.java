
public class heap {
	private boolean maxheap;
	private node headNode = null;
	public heap(boolean maxheap){
		this.maxheap = maxheap;
	}
	
	public String head(){
		if (headNode == null){
			return "";
		}
		return headNode.data();
	}
	
	public void add(String value){
		if (headNode == null){
			headNode = new node(value);
		}
		
		
		return;
	}
	

}
