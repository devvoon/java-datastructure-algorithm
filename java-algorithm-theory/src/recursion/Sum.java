package recursion;

public class Sum {

    /**
     * resuion - 1~~n까지의 sum을 구하기
     * @param args
     */
    public static void main(String[] args) {

        int n = 5;
        System.out.println("n : " + n);
        
        /* 1~ n 까지의 합 구하기 */
        // recursion
        System.out.println("=====recusrion을 이용한 1~n까지의 합 구하기=====");
        int sumOfRecursion = functionRecursion(n);
        System.out.println( );
        System.out.println("sum of 1 ~ n  : " + sumOfRecursion);

        //for
        System.out.println("=====for을 이용한 1~n까지의 합 구하기=====");
        int sumOfFor = functionFor(n);
        System.out.println( );
        System.out.println("sum of 1 ~ n  : " + sumOfFor);        
    }
    
    /**
     * recusrion을 이용한 1~n까지의 합 구하기
     * @param n
     * @return
     */
    public static int functionRecursion(int n) {
        if(n==0) {
            return 0;
        }else {
            System.out.print(n + " ");
            return n + functionRecursion(n-1);
        }
    }
    
    /**
     * for을 이용한 1~n까지의 합 구하기
     * @param n
     * @return
     */
    public static int functionFor(int n) {
        int sum = 0;
        
        //1~n 까지의 합 
        // for (int i = 1; i <= n; i++) {
        
        //n~1 까지의 합 
        for (int i = n ;  i > 0 ; i--) {       
            sum = sum + i;
            System.out.print(sum + " ");
        }
        return sum;
    }
    
}
