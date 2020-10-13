package baekjoon.fibonacci2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  2747 피보나치 수
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/2747
 *
 */
public class MainRecursion {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int n = Integer.parseInt(br.readLine());
        
        int result = fibonacci(n);
        System.out.println(result);
        
        br.close();
        isr.close();
    }

    private static int fibonacci(int n) {
        
        if (n == 0) {
            return 0;
        } else if ( n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
