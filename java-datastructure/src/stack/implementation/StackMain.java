package stack.implementation;

public class StackMain {

    /**
     * stack implementation 실행 
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("===== createion stack and check size of stack=====");
        //create()
        Stack stack = new Stack(5);
        System.out.println(stack.size());
        
        System.out.println("===== insertion  : 저장 push() =====");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println();
        System.out.println("===== access =====");
        System.out.println(stack);
        
        System.out.println();
        System.out.println("===== insertion (more than stack size) : overflow occur =====");
        stack.push(60);
        
        System.out.println();
        System.out.println("===== deletion : pop() =====");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        System.out.println();
        System.out.println("===== search : top() =====");
        System.out.println(stack.top());
        
        System.out.println();
        System.out.println("===== access =====");
        System.out.println(stack);
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        System.out.println("===== deletion (empty stack)  =====");
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack);
        
    }

}
