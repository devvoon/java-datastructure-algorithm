package baekjoon.problem11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11066 파일합치기
 * 
 * @references https://www.acmicpc.net/problem/11066
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); //테스트 케이스
        
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
        
        //sum[i] = 1 ~ i번째 까지의 누적합
        int[] sum = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            sum[i] = sum[i-1] + arr[i];
        } 
        
        //dp[i][j] = i 에서 j까지 합하는데 최소비용
        //dp[i][k] + dp[k+1][j] + sum(A[i]~A[j])
        int[][] dp = new int[n+1][n+1];
        
        
        //부분파일의 길이
        for (int i = 2; i < n+1; i++) {
            //시작점
            for (int j = 1; j < n+2-i; j++) {
                int min = Integer.MAX_VALUE;
                System.out.print(i + "> j: " + j  );
                for (int k = 0; k < i-1; k++) {
                    min = Math.min(min, dp[j][j+k] + dp[j+k+1][j+i-1]);
                    System.out.print( " k: "+ k);
                }
                System.out.print(" j+i-1 : " + (j+i-1));
                
                dp[j][j+i-1] = min + (sum[j+i-1] - sum[j-1]);
                System.out.print( "  == " + dp[j][j+i-1]);
                System.out.println();
            }
        }
        
        /*
        
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        
        System.out.println(dp[1][n]);

    }

}
