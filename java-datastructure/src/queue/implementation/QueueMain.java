package queue.implementation;

/**
 * array를 이용하여 array queue를 구현해보기 
 * @author iamdawoonjeong
 *
 */
public class QueueMain {

	public static void main(String[] args) {
			
		System.out.println("===== createion queue and check size of stqueueack=====");
		//create()
		Queue queue = new Queue(5);
		System.out.println(queue.size());
		
		System.out.println("===== insertion :  저장 add() =====");
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		queue.add("E");
		
		System.out.println(queue.toString());
		
		System.out.println("===== deletion  : 삭제 remove() =====");
		queue.remove();
		queue.remove();
		queue.remove();
		
		System.out.println(queue.toString());
		
		System.out.println(queue.poll());
		
		
	}

}
