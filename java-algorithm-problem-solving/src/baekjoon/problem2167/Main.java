package baekjoon.problem2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2167 두 개의 손
 * 
 * @references https://www.acmicpc.net/problem/2167
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); //n개의 줄에
        int m = Integer.parseInt(st.nextToken()); //m개의 정수로 이루어짐
        
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                //구하는 좌표의 같은행 앞 열까지 + 윗행 누적합 - 교집합 + 더해야할 합
                dp[i][j] = dp[i-1][j] + dp[i][j-1]- dp[i-1][j-1] + arr[i][j];
            }
        }

        //합을 구할 부분의 개수 K,  K개의 줄에는 네 개의 정수로 i, j, x, y가 주어짐
        int k = Integer.parseInt(br.readLine()); 
        int[] result = new int[k];
        for (int p = 0; p < k; p++) {
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);
            result[p]= dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
        } 
        
        for (int i : result) {
            System.out.println(i);
        }
        
    }

}
