package baekjoon.problem11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11055 가장 큰 증가 부분 수열
 * 
 * @references https://www.acmicpc.net/problem/11055
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr =new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        dp[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
        }
        
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        
        System.out.println(max);

    }

}
