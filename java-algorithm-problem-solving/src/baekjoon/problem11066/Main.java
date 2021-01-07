package baekjoon.problem11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCase; i++) {
            
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            for (int j = 1; j < n+1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            solution(arr, n);
        }
    }

    public static void solution(int[] arr, int n) {
        int[] sum = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            sum[i] = sum[i-1] + arr[i];
        } 
        
        int[][] dp = new int[n+1][n+1];
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < n+1-i; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j+i-1] = Math.min(dp[j][j+k] + dp[j+k+1][j+i-1], dp[k][i])+ (sum[j+i-1]+sum[j-1]); 
                }
                
            }
        }
        
    }

}
