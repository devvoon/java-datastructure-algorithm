package baekjoon.problem1668;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1668 트로피 진열
 * 
 * @references https://www.acmicpc.net/problem/1668
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            br.close();
            isr.close();

            int left = 1; //왼쪽에서보는 갯수 
            int lastL = arr[0];
            
            for (int i = 1; i < arr.length; i++) {
                if ( lastL < arr[i]) {
                    lastL = arr[i];
                    left++;
                }
            }
            
            System.out.println(left);
            
            int right = 1;  //오른쪽에서 보는 갯수
            int lastR = arr[n-1];
            
            for (int j = n-2; j >= 0; j--) {
                if ( lastR < arr[j]) {
                    lastR = arr[j];
                    right++;
                }
            }
            
            System.out.println(right);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
