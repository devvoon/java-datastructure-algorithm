package baekjoon.problem11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11053 가장 긴 증가하는 부분 수열
 * 
 * @references https://www.acmicpc.net/problem/11053
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
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
