package linkedList;

public class IntegerNode {
	private int item;
	private IntegerNode next;
	
	// constructors
	public IntegerNode(int newItem) {
		item = newItem;
		next = null;
	}
	
	public IntegerNode(int newItem, IntegerNode nextNode) {
		item = newItem;
		next = nextNode;
	}
	
	public void setItem(int newItem) {
		item = newItem;
	}
	
	public int getItem() {
		return item;
	}
	
	public void setNext(IntegerNode nextNode) {
		next = nextNode;
	}
	
	public IntegerNode getNext() {
		return next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
