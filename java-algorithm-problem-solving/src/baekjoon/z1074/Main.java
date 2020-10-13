package baekjoon.z1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  1074 Z
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1074
 *
 */
public class Main {
    
    static int N;
    static int r;
    static int c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        String[] arr = br.readLine().split(" ");
        
        br.close();
        isr.close();
        
        N = Integer.parseInt(arr[0]);
        r = Integer.parseInt(arr[1]);
        c = Integer.parseInt(arr[2]);
                
        recursion((int)(Math.pow(2, N)), 0, 0);
        
    }
    
    private static void recursion(int n, int x, int y) {
        
        //n=2 가 될때까지 (2*2 사각형 될때 까지 쪼개기)
        if (n == 2) {
            //(0,0)
            if (x == r && y == c) {
                System.out.println(count);
                return;
            }
            count++;
           
            //(0,1)
            if (x == r && y+1 == c ) {
                System.out.println(count);
                return;
            }
            count++;
            
           //(1,0)
            if (x+1 == r && y == c) {
                System.out.println(count);
                return;
            }
            count++;
            
            //(1,1)
            if (x+1 == r && y+1 == c) {
                System.out.println(count);
                return;
            }
            count++;
            return;
        }
        
        recursion(n/2 , x, y );        // 1사분면 탐색
        recursion(n/2 , x, y+n/2);     // 2사분면 탐색
        recursion(n/2 , x+n/2, y );    // 3사분면 탐색
        recursion(n/2 , x+n/2, y+n/2); // 4사분면 탐색
    }

}
