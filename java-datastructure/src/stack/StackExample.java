package stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Stack Framework Collection을 이용하여 Stack 사용해보기
 * @author iamdawoonjeong
 *
 */
public class StackExample {

    public static void main(String[] args) {
        
        //Stack class 사용 
        
        System.out.println("===== stack 생성 =====");
        Stack<Integer> stk = new Stack<Integer>();
        
        System.out.println("===== insertion :  저장 add() =====");
        stk.add(1);
        stk.add(2);
        stk.add(3);
        stk.add(4);
        stk.add(5);
        
        System.out.println(stk.peek());
        
        System.out.println("=====  deletion  : 삭제 remove() =====");
        stk.remove(4);
        stk.remove(3);
        
        System.out.println(stk);
        
        System.out.println("=====  peek() =====");
        System.out.println(stk.peek());
        
        System.out.println("===== access : 순차적으로 읽기 - Iterator =====");
        Iterator<Integer> iterator = stk.iterator();  
        while(iterator.hasNext())  
        {  
            int values = iterator.next();
            System.out.print(values + " ") ;
        }
    }
}
