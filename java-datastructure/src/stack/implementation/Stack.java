package stack.implementation;


/**
 * 배열을 이용해서 stack 구현해보기 
 * @author iamdawoonjeong
 *
 */
public class Stack {

	private int top = -1;    // stack의 현재 위치 
	private int size = 100;  // 초기화시 기본 배열 크기 
	private Object[] elementData = new Object[size];  //배열 
	
	public Stack() {}
	
	public Stack(int size) {
		//stack 사이즈 지정시 초기화 
		Object[] elementData = new Object[size];
		this.size = size;
	}
	
	/**
	 * element insertion
	 * @param element
	 * @return
	 */
	public boolean push(Object element) {
		
		if (isOverFlow()) {
			System.out.println("...overflow");
			return false;
		}else {
			top++;
			elementData[top] = element;
		}
		
		return true;
	}

	/**
	 * element deletion
	 * @return
	 */
	public Object pop() {
				
		if(isEmpty()) {
			System.out.println("...empty");
			return false;
		}else {
			Object removedElement  = elementData[top];
			elementData[top] = null;
			top--;
			return removedElement;
		}
		
	}
	
	/**
	 * check overflow
	 * @return
	 */
	private boolean isOverFlow() {
		
		//현재 top의 위치가 size -1 보다 크면 overflow 
		if (top >= size-1){
			return true;
		}
		return false;
	}

	/**
	 * check empty 
	 * @return
	 */
	private boolean isEmpty() {
		
		if (top < 0) {
			return true;
		}
		return false;
	}

	/**
	 * value of size
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * value of top 
	 * @return
	 */
	public Object top() {
		
		if (top < 0) {
			return false;
		}
		
		return elementData[top];
	}
	
	/**
	 * print elements
	 */
	public String toString()	{
		String str = "[" ; 
		
		for (int i = 0; i < top + 1 ; i++) {
			str = str + elementData[i];
			if (i < top) {
				str = str + ",";
			}
		}
		return str + "]";
	}

	
}
