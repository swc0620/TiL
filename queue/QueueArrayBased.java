package queue;

public class QueueArrayBased {
	final int MAX_QUEUE = 50;
	private Object items[ ];
	private int front, back, numItems;
	
	public QueueArrayBased( ) {
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE –1;
		numItems = 0;
	}	
	
	public boolean isEmpty( ) {
		return(numItems == 0);
	}
	
	public boolean isFull ( ) {
		return(numItems == MAX_QUEUE);
	}
	
	public void enqueue(Object newItem) {
		if (!isFull( )) {
			back = (back+1) % MAX_QUEUE;
			items[back] = newItem;
			++numItems;
		} else{
			Exception handling;
		}
	}
	
	public Object dequeue( ) {
		if (!isEmpty( )) {
			Object queueFront = items[front];
			front = (front+1) % MAX_QUEUE;
			--numItems;
			return queueFront;
		} else{
			Exception handling;
		}
	}
	
	public void dequeueAll ( ) {
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE –1;
		numItems = 0;
	}
	
	public Object peek( ) {
		if (!isEmpty( )) {
			return items[front];
		} else{
			Exception handling;
		}
	}
}
