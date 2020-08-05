package recursion;

public class Factorial {

    public static void main(String[] args) {
    
        int n = 5;
        System.out.println("n : "  + n);
        
        /* n! 구하기 */
        //recusrion
        System.out.println("=====recusrion을 이용한 n! 구하기=====");
        int factorialOfRecursion = factorialRecursion(n);
        System.out.println( );
        System.out.println("n! : " + factorialOfRecursion);
        
        //for
        System.out.println("=====for 문을 이용한 n!구하기=====");
        int factorialOfFor = factorialFor(n);
        System.out.println( );
        System.out.println("n! : " + factorialOfFor);    
        
    }
    
    /**
     * recusrion을 이용한 n! 구하기
     * @param n
     * @return
     */
    public static int factorialRecursion(int n) {
        if(n==0) {
            return 1;
        }else {
            System.out.print(n + " ");
             return n*factorialRecursion(n-1);
        }
    }
    
    /**
     * for 문을 이용한 n!구하기
     * @param n
     * @return
     */
    public static int factorialFor(int n) {
        int sum = 1;
        for (int i = n; i > 0; i--) {
            System.out.print(sum + " ");
            sum = sum * i;
        }
        return sum;
    }

}
