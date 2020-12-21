package baekjoon.problem1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  1932 정수 삼각형
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1932
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        
        for (int i = 1; i < n+1; i++) {
            String[] input = br.readLine().split(" ");
            
            for (int j = 1; j < input.length+1; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            
            }
        }

        int[][] dp = new int[n+1][n+1];
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j]; 
            }
        }
        
        int max = 0;
        for (int i = 1; i < n+1; i++) {
            max = Math.max(max, dp[n][i]);
        }
        
        System.out.println(max);

    }


}
