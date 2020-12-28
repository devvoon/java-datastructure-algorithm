package baekjoon.problem1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1915 가장 큰 정사각형
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1915
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+1][m+1];
        
        for (int i = 1; i < n+1; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        int[][] dp = new int[n+1][m+1];
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (arr[i][j] == 1) {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(min, dp[i-1][j-1])+1;
                }
            }
        }
        
        int max = 0 ;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        
        int result = max*max;
        System.out.println(result);

    }

}
