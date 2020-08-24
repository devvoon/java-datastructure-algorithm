package list.linkedlist.implementation;

/**
 * LinkedList를 노드를 직접 구현해보기
 * @author iamdawoonjeong
 *
 */
public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        
        
        System.out.println("===== addFirst() =====");
        numbers.addFirst(30);
        numbers.addFirst(20);
        numbers.addFirst(10);
        System.out.println(numbers);
        
        System.out.println("===== addLast() =====");
        numbers.addLast(40);
        numbers.addLast(50);
        numbers.addLast(60);
        System.out.println(numbers);

        //System.out.println(numbers.node(2));
        System.out.println("===== add() =====");
        numbers.add(1,15);
        System.out.println(numbers);
        
        System.out.println("===== removeFirst() =====");
        numbers.removeFirst();
        System.out.println(numbers);
        
        System.out.println("===== remove() =====");
        System.out.println(numbers.remove(3));
        System.out.println(numbers);

        System.out.println("===== removeLast() =====");
        System.out.println(numbers.removeLast());
        System.out.println(numbers);
        
        System.out.println("===== size() =====");
        System.out.println(numbers.size());
        
        System.out.println("===== get() =====");
        System.out.println(numbers.get(0));
        
        System.out.println("===== indexOf() =====");
        System.out.println(numbers.indexOf(40));
        
        System.out.println("=====Iteration : clasee 생성 =====");
        System.out.println("=====next() =====");
        //numbers의 listIterator을 호출하면  ListIterator 클래스가 인스턴스화 되어서 호출되어 객체가 되고 
        // 타입은 LinkedList내에 ListIterator클래스 가 되어짐
        LinkedList.ListIterator i = numbers.listIterator();
        
        System.out.println(i.next());
        System.out.println(i.hasNext());
        System.out.println(i.next());
        System.out.println(i.hasNext());
        System.out.println(i.next());
        System.out.println(i.hasNext());
        System.out.println(i.next());
        System.out.println(i.hasNext());
        
        System.out.println(numbers);
        
        System.out.println("=====addFirst() =====");
        numbers.addFirst(10);
        System.out.println(numbers);
        
        System.out.println("=====add() =====");
        LinkedList.ListIterator li = numbers.listIterator();
        li.add(5);
        System.out.println(numbers);

    }

}

