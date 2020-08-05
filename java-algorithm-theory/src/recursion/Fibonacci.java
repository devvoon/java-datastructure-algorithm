package recursion;

public class Fibonacci {

    public static void main(String[] args) {
 
        int n = 10;
        System.out.println("n : "  + n);
        
        /* fibonacci 구하기 */
        //recursion
        System.out.println("=====recusrion을 fibonacci수 구하기=====");
        
        for (int i = 0; i < n; i++) {
            int fibonacciOfRecusrion = fibonacciRecusrion(i);
            System.out.print(fibonacciOfRecusrion + " ");
        }
        System.out.println( );
        
        // for
        System.out.println("=====for을 fibonacci수 구하기=====");
        for (int i = 0; i < n; i++) {
            int fibonacciOfFor = fibonacciFor(i);
            System.out.print(fibonacciOfFor + " ");
        }

    }
    
    /**
     *  recusrion을 fibonacci수 구하기
     * @param n
     * @return
     */
    public static int fibonacciRecusrion(int n) {
        if(n < 2) {
            return n;
        }else{
            return fibonacciRecusrion(n-1) + fibonacciRecusrion(n-2);
        }
    }
    
    /**
     * for문을 fibonacci수 구하기
     * @param n
     * @return
     */
    public static int fibonacciFor(int n) {
          if (n < 2) {
              return n;
          } else {
              
              int a = 0; //f0
              int b = 1;  //f1 
              int sum = 0;   //fn 
              
              for (int i = 2; i <= n; i++) {
                  sum = a + b; // fn = f(n-1) + f(n-2)  = f0 + f1
                  a = b;
                  b = sum;
              }
              return sum;
          }
    }

}
