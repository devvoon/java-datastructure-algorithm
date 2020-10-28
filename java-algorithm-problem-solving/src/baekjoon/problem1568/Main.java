package baekjoon.problem1568;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1568 새
 * 
 * @references https://www.acmicpc.net/problem/1568
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            int n = Integer.parseInt(br.readLine());
            int k=1;
            int count=0;
            
            while(n != 0) {
                
                if (k > n) {
                    k=1;
                }
                n=n-k;
                k++;
                count++;

            }
            
            System.out.println(count);
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
