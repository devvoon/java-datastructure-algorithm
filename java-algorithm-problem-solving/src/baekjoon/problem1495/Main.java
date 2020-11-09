package baekjoon.problem1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1495 기타리스트
 * 
 * @references https://www.acmicpc.net/problem/1495
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        dp[0][s] = 1;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (dp[i-1][j] == 0) {
                    //이전 곡 같은 볼륨이 0일 경우, 아래 연산을 하지 않고 다음 분기로 바로 넘어감 
                    continue;
                }
                
                if ( j-arr[i] >= 0 ) {
                    dp[i][j-arr[i]] = 1;
                }
                
                if ( j+arr[i] <= m ) {
                    dp[i][j+arr[i]] = 1;
                }
            }
        }
        
        int result = -1;

        // 마지막 곡만 탐색
        for (int j = m ; j > -1; j--) {
            if (dp[n][j]==1) {
                result = j;
                break;
            }
        }
        
        System.out.println(result);
        
    }

}
