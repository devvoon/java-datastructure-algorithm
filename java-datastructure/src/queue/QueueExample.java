package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue Collection Framework을 이용하여 queue 사용해보기 
 * @author iamdawoonjeong
 *
 */
public class QueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("===== queue 생성 =====");
		//Queue는 interface라 직접 객체 생성을 할 수 없으므로, LinkedList 로 인스턴스 생성
		Queue<String> queue = new LinkedList<String>();
		
		System.out.println("===== insertion :  저장 add() =====");
		queue.add("A");
		System.out.println(queue);
		queue.add("B");
		System.out.println(queue);
		queue.add("C");
		System.out.println(queue);
		queue.add("D");
		System.out.println(queue);
		queue.add("E");

		System.out.println("===== access : 순차적으로 읽기 - Iterator =====");
		Iterator<String> iterator = queue.iterator();
		while(iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value + " ");
		}
		
		
		System.out.println("===== 해당 큐의 head 조회 - poll() =====");
		System.out.println(queue.poll());
		System.out.println(queue.offer("F"));
		
		System.out.println("=====  deletion  : 삭제 remove() =====");
		// 먼저 입력했던 데이터가 삭제됨 FIFO
		queue.remove();
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		
		System.out.println("===== 해당 큐의 head 조회 - poll() =====");
		System.out.println(queue.poll());
		
		
	}

}
