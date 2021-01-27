package baekjoon.problem12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 12100 2048 (Easy)
 * 
 * @references https://www.acmicpc.net/problem/12100
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int result = dfs(n, arr, 5);

        System.out.println(result);
    }

    public static int dfs(int n, int[][] arr, int count) {
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        
        if (count == 0 ) {
            return max;
        }
        
        //상하좌우 -> 4 
        for (int i = 0; i < 4; i++) {
            int[] row = new int[n];
            
            int[] convertedRow; 
            int[][] temp = new int[n][n];
            
            for (int x = 0; x < n; x++) {
                convertedRow = new int[n];
                
                for (int y = 0; y < n; y++) {
                    row[y] =  arr[x][y];
                }
                convertedRow = convert(row, n);
                
                for (int y = 0; y < n; y++) {
                    temp[x][y] = convertedRow[y];
                }
            }
            
            if (!Arrays.equals(arr, temp)) {
                max = Math.max(max, dfs(n, temp, count-1));
            } 
            
            arr = rotate90(arr, n);
        }
        
        return max;
    }
    
    public static int[][] rotate90(int[][] arr, int n) {
        
        int[][] rotateArr = arr.clone();
        
        // 기존 배열 90도로 돌리기 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //rotateArr[j][n-i-1]  = arr[i][j];
                rotateArr[n-j-1][i]  = arr[i][j];
            }
        }
        
        return rotateArr;
    }
    
    // 하나의 세로 줄을 왼쪽으로 슬라이스 했을때 생기는 결과물 
    public static int[] convert(int[] row, int n ) {
        
        int[] convertRow = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (row[i] > 0) {
                convertRow[index] = row[i];
                index++;
            }
        }
        
        //2 2 2 2 -> 4 0 4 0 
        for (int i = 1; i < n; i++) {
            if (convertRow[i-1]  == convertRow[i]) {
                convertRow[i-1] *= 2;
                convertRow[i] = 0;
            }
        } 
        
        return convertRow;
    }

}
