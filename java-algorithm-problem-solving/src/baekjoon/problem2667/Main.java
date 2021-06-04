package baekjoon.problem2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 2667 단지번호붙이기
 * 
 * @references https://www.acmicpc.net/problem/2667
 * @author iamdawoonjeong
 */
public class Main {

    public static int num;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        boolean[][] visited = new boolean[n][n];
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]==1 && !visited[i][j]) {
                    count++;
                    num=0;
                    dfs(arr, visited, n, i, j);
                    result.add(num);
                }
            }
            
        }
        
        System.out.println(count);
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    

    }

    private static void dfs(int[][] arr, boolean[][] visited, int n, int x, int y) {
        
        visited[x][y] = true;
        num++;
        
        int[] dx = new int[] {0,1,0,-1};
        int[] dy = new int[] {1,0,-1,0};
        
        for (int k = 0; k < dx.length; k++) {
            int nextX = x+dx[k];
            int nextY = y+dy[k];
            
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n ) {
                continue;
            }
            
            if(arr[nextX][nextY]==1 && !visited[nextX][nextY]) {
                dfs(arr, visited, n , nextX, nextY);
            }
        }
        
    }

}
