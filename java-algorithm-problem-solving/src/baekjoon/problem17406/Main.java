package baekjoon.problem17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 17406 배열 돌리기 4
 * 
 * @references https://www.acmicpc.net/problem/17406
 * @author iamdawoonjeong
 */
public class Main {

    public static int n,m,k, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
         
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        int[][] rcs = new int[k][3];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rcs[i][0] =  Integer.parseInt(st.nextToken());
            rcs[i][1] =  Integer.parseInt(st.nextToken());
            rcs[i][2] =  Integer.parseInt(st.nextToken());
            
        }
        
        result = 10000;
        
        for (int i = 0; i < k; i++) {
            int[] row = new int[3];
            for (int j = 0; j < 3; j++) {
                row[j]  = rcs[i][j];
            }
            
            dfs(arr, row);
        }
        
    }

    // 각 row 의 합 중에 최소값 구하기
    public static int value(int[][] arr){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
               sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        
        return min;
    }
    

    public static void dfs(int[][] arr, int[] row) {
        
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        
        if (sum == k ) {
            result = Math.min(result, value(arr));
            return;
        }
        
        for (int i = 0; i < k; i++) {
            if (row[i] == 1) {
                continue;
            }
            int[][] convertedArr = convert(arr);
            row[i] = 1;
            dfs(convertedArr, row);
            row[i] = 0;
        }
        
        
    }

    private static int[][] convert(int[][] arr) {
        // (r, c ,s )= 
        return null;
    }

}
