package list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList Collection Framework를 이용한 ArrayList 사용해보기 
 * @author iamdawoonjeong
 *
 */
public class ArrayListExample {

    public static void main(String[] args) {
        
        // Creating object of the class Array List
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        
        for (int i = 0 ; numbers.size() > i ; i++) {
            System.out.print( i + "," + numbers.get(i)  + " ");
        }

        System.out.println();
        System.out.println("===== insertion : add(1,50) =====");
        //인덱스 1에 값 50을 넣고, 기존 값들은 뒤로 밀림
        numbers.add(1, 50);
        
        for (int i = 0 ; numbers.size() > i ; i++) {
            System.out.print( i + "," + numbers.get(i)  + " ");
        }
        
        System.out.println();
        System.out.println("===== 순차적으로 읽기  - Iterator =====");
        
        Iterator<Integer> intIterator = numbers.iterator();
        while (intIterator.hasNext()) {
            int value = intIterator.next();
            System.out.print(value + " " );
            
        }
        
        System.out.println();
        System.out.println("===== 순차적으로 읽기 - foreach =====");
        
        for (Integer intForeach : numbers) {
            System.out.print(intForeach + " ");
        }
        
        System.out.println();
        System.out.println("=====  remove  =====");
        //인덱스 2에 remove 하면 뒤에 값들이 앞으로 당겨짐(LIST의 특징인 빈공간이 없는 장점) 
        numbers.remove(2);
        for (int i = 0 ; numbers.size() > i ; i++) {
            System.out.print( i + "," + numbers.get(i)  + " ");
        }
    }
}
