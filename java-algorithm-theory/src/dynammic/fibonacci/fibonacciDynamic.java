package dynammic.fibonacci;

/**
 * Dynamic Programming으로 fibonacci 수열 구현 
 * @author iamdawoojeong
 */
public class fibonacciDynamic {

    public static void main (String args[]) 
    { 
         int n = 9; 
         System.out.println(fibonacci(n)); 
    }
    
    /**
     * dynamic programming으로 fibonacci 구현 
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        // fibonacci를 저장할 배열 선언 
        int f[] = new int[n+1];
        int i;
        
        //점화식으로 f(0)=1, f(1)=1을 미리 정의
        f[0] = 0;
        f[1] = 1;
        
        for (i = 2; i <= n ; i++) {
            // 위에서 저장한 0,1번째 수를 제외하고 2번째 부터 저장
            f[i] = f[i-1] + f[i-2];
            System.out.println("i = " + i + " : "  +f[i] + " = "  +  f[i-1] + " + " + f[i-2]);
       }
        return f[n];
    }
}
/* This code is contributed by Rajat Mishra */