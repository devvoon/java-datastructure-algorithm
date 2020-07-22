package list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList Collection Framework를 이용한 LinkedList 사용해보기
 * @author iamdawoonjeong
 *
 */
public class LinkedListExample {
    
    public static void main(String[] args) {

        // Creating object of the class linked list 
        LinkedList<String> ll = new LinkedList<String>();
  
        // Adding elements to the linked list 
        System.out.println("===== insertion : linkedList.add(element) =====");
        ll.add("A"); 
        ll.add("B"); 
        System.out.println(ll);
        
        System.out.println("===== insertion : addLast(element), addFrist(element) =====");
        ll.addLast("C"); 
        System.out.println(ll);
        
        ll.addFirst("D"); 
        System.out.println(ll);
        
        System.out.println("===== store : add(index, element) =====");
        ll.add(2, "E"); 
        System.out.println(ll); 
  
        System.out.println("===== deletion : remove(element), remove(index) =====");
        ll.remove("B");
        System.out.println(ll); 
        
        ll.remove(3); 
        System.out.println(ll); 
        
        System.out.println("===== deletion : reremoveFirstmove(), removeLast() =====");
        ll.removeFirst(); 
        ll.removeLast(); 
        System.out.println(ll); 
        
        System.out.println("===== insertion ===== ");
        ll.add("B"); 
        ll.add("C"); 
        ll.add("D");
        ll.add("E"); 
        System.out.println(ll);
        
        System.out.println("===== length : size() =====");
        System.out.println(ll.size());
        
        System.out.println("===== searching : get(index) =====");
        System.out.println(ll.get(0)); 
        
        System.out.println("===== 순차적으로 읽기 - for =====");
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        
        System.out.println();
        System.out.println("===== 순차적으로 읽기 - Iterator =====");
        Iterator<String> it = ll.iterator();
        while(it.hasNext()) {
            String values = it.next();
            System.out.println(values + " ");
        }
    }
}
