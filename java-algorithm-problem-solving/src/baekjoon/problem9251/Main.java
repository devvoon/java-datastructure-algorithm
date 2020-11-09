package baekjoon.problem9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9251 LCS
 * 
 * @references https://www.acmicpc.net/problem/9251
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] x = br.readLine().toCharArray();
        char[] y = br.readLine().toCharArray();
        
        int[][] dp = new int[x.length+1][y.length+1];
        
        dp[0][0] = 0;
        for (int i = 1; i < x.length+1; i++) {
            for (int j = 1; j < y.length+1; j++) {
                
                if (x[i-1] == y[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        System.out.println(dp[x.length][y.length]);

    }

}

