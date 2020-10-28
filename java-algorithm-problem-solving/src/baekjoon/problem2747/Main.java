package baekjoon.problem2747;

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
public class Main {

    public static void main(String[] args) throws IOException {
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int n = Integer.parseInt(br.readLine());
        
        int result = fibonacci(n);
        System.out.println(result);
        
        br.close();
        isr.close();
    }

    private static int fibonacci(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        int i;
        
        for (i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

}
