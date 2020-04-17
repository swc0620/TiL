package stack;

public class StackArrayBased {
	final int MAX_STACK = 50;
	private Object items[ ];
	private int top; // index for stack top
	
	// constructor
	public StackArrayBased( ) {
		items = new Object[MAX_STACK];
		top = –1;
	}
	
	public boolean isEmpty( ) {
		return(top < 0);
	}
	public boolean isFull( ) {
		return(top == MAX_STACK – 1);
	}
	public void push(Object newItem) {
		if (!isFull( )) {
			items[++top] = newItem;
		}
		else{
			Exception handling;
		}
	}
	
	public Object pop( ) {
		if (!isEmpty( )) {
			return items[top--];
		}
		else{
			Exception handling;
		}
	}
	
	public void popAll( ) {
		items = new Object[MAX_STACK];
		top = –1;
	}
	
	public Object peek( ) {
		if (!isEmpty( )) {
			return items[top];
		}
		else{
			Exception handling;
		}
	}
}
