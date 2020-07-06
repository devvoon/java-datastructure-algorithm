package list.arraylist.implementation;

/**
 * 배열을 이용하여 Array List를 직접 구현해보기 
 * @author iamdawoonjeong
 *
 */
public class ArrayListMain {

	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();

		System.out.println("=====addLast =====");
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);		
		System.out.println(numbers);
		
		System.out.println("=====add =====");
        numbers.add(1, 15);
        System.out.println(numbers);
     	
        System.out.println("=====addFirst =====");
		numbers.addFirst(5);
	    System.out.println(numbers);
	    
	    System.out.println("=====remove =====");
	    System.out.println(numbers.remove(1)); 
	    System.out.println(numbers);
	    
	    
	    System.out.println("=====removeLast =====");
	    System.out.println(numbers.removeLast());
	    
	    System.out.println("=====removeFirst =====");
	    System.out.println(numbers.removeFirst());
	    System.out.println(numbers);
	    
	    System.out.println("=====get =====");
	    System.out.println(numbers.get(0));
	    System.out.println(numbers.get(1));
	    System.out.println(numbers.get(2));
	    
	    System.out.println("=====size =====");
	    System.out.println(numbers.size());
	    
	    System.out.println("=====indexOf =====");
	    System.out.println(numbers.indexOf(30));
	    System.out.println(numbers.indexOf(10));
	    
	    System.out.println("=====Iteration : for=====");
	    for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
	    
	    System.out.println("=====Iteration : clasee 생성 =====");
	    System.out.println("=====next() =====");
	    ArrayList.ListIterator li = numbers.listIterator();
	    //System.out.println(li.next());
	    //System.out.println(li.next());
	    //System.out.println(li.next());
	    //System.out.println(li.next()); // 가져올 값이 없을 경우 null
	    
	    while(li.hasNext()) {
	    	System.out.println(li.next());
	    }
	    
	    System.out.println("=====previous()=====");
	    //System.out.println(li.previous());
	    //System.out.println(li.previous());
	    //System.out.println(li.previous());
	    //System.out.println(li.previous()); //index범위 벗어나면 :  error java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 100
	    
	    while(li.hasPrevious()) {
	    	System.out.println(li.previous());
	    }
	   
	    
	    System.out.println("=====add,remove=====");
	    while(li.hasNext()) {
	    	int number = (int)li.next();
	    	if(number == 30) {
	    		li.add(35);
	    		//li.remove();
	    	}
	    }
	    System.out.println(numbers);
	    
	}
	

}
