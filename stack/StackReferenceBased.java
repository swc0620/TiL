package stack;

public class StackReferenceBased {
	private Node top;
	
	// constructor
	public StackReferenceBased( ) {
		top = null;
	}
	
	public boolean isEmpty( ) {
		return(top == null);
	}
	
	public void push(Object newItem) {
		top = new Node(newItem, top);
	}
	
	public Object pop( ) {
		if(!isEmpty( )) {
			Node temp = top;
			top = top.getNext( );
			return temp.getItem( );
		} else {
			Exception handling;
		}
	}
	
	public void popAll ( ) {
		top = null;
	}
	
	public Object peek( ) {
		if (!isEmpty( )) {
			return top.getItem( );
		} else{
			Exception handling;
		}
	}
}
