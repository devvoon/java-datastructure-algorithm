package queue.implementation;

public class Queue {
	private int size = 100;
	private Object[] elementData = new Object[size];
	private int front = -1;
	private int rear = -1;

	
	public Queue() {}
	
	public Queue(int size) {
		Object[] elementData = new Object[size];
		this.size = size;
	}
	
	public boolean add(Object element) {
		
		if (isOverFlow()) {
			System.out.println("...queue over flow");
			return false;
		}else {
			if (front == -1 && rear == -1 ) {
				front++;
				rear++;
			}else {
				rear ++;
			}
			
			elementData[rear] = element;
		}
		
		return true;
		
	}

	public Object remove() {
		if (isEmpty()) {
			System.out.println("... queue empty");
			return false;
		}else {
			Object removedElement = elementData[front];
			elementData[front] = null;
			front++;
			return removedElement;
		}
	}
	
	
	private boolean isEmpty() {
		if ( front < 0) {
			return true;
		}
		return false;
	}

	private boolean isOverFlow() {
		
		if (rear > size-1 ) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public Object poll() {
		return elementData[front];
	}

	public String toString() {
		String str = "[";
		
		for (int i = front; i <= rear ; i++) {
			str = str+ elementData[i];
			if (i < rear) {
				str = str+ ",";
			}
		}
		return str + "]";
	}

}
