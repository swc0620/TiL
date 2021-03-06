package queue;

public class Node {
	private Object item;
	private Node next;
	
	// constructor
	public Node(Object newItem) {
		item = newItem;
		next = null;
	}
	
	public Node(Object newItem, Node nextNode) {
		item = newItem;
		next = nextNode;
	}
	
	public void setItem(Object newItem) {
		item = newItem;
	}
	
	public Object getItem() {
		return item;
	}
	
	public void setNext(Node nextNode) {
		next = nextNode;
	}
	
	public Node getNext() {
		return next;
	}
	
public class ListInterface {
	public boolean isEmpty();
	public int size();
	public void add(int index, Object item);
	public void remove(int index);
	public Object get(int index);
	public void removeAll();
}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(5);
		
		for(Node curr = head; curr != null; curr = curr.getNext()) {
			System.out.println(curr.getItem());
		}
	}

}
