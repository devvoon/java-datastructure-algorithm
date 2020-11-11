package baekjoon.problem1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1012 유기농 배추
 * 
 * @references https://www.acmicpc.net/problem/1012
 * @author iamdawoonjeong
 */
public class Main {

    public static int m = 0;
    public static int n = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[][] adjacent  = new int[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adjacent[x][y] = 1;
            }
            
            int result = 0;
            boolean[][] visited = new boolean[m][n];
            for (int p = 0; p < m; p++) {
                for (int q = 0; q < n; q++) {
                    if (adjacent[p][q] == 1 && !visited[p][q]) {
                        dfs(adjacent, visited, p, q);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    private static void dfs(int[][] adjacent, boolean[][] visited, int x, int y) {
        
        visited[x][y] = true;
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        for (int[] is : directions) {
            int nextX = x+is[0];
            int nextY = y+is[1];
            
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n ) {
                continue;
            }
            
            if (adjacent[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                dfs(adjacent, visited, nextX, nextY);
            }
        }
    }

}
