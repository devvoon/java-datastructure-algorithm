package baekjoon.problem11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11047 동전 0
 * 
 * @references https://www.acmicpc.net/problem/11047
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); //동전의 갯수
        int k = Integer.parseInt(st.nextToken()); //잔액
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            
            // 현재 동전의 금액이 잔액보다 큰 경우 다음 동전으로 넘어감
            if (k < arr[i]) {
                continue;
            }

            count = count + k/arr[i]; //동전의 갯수 
            k = (k%arr[i]);   // 잔액 
            if (k==0) {
                break;
            }
        } 
        
        System.out.println(count);
        
    }

}
