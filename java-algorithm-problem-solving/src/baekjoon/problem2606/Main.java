package baekjoon.problem2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2606 바이러스
 * 
 * @references https://www.acmicpc.net/problem/2606
 * @author iamdawoonjeong
 */
public class Main {

    public static int count = 0; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] adjacent = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            adjacent[from][to] = 1;
            adjacent[to][from] = 1;
        }

        dfs(adjacent, visited, 1);
        System.out.println(count);

    }

    public static void dfs(int[][] adjacent, boolean[] visited, int vertex) {
        visited[vertex] = true;
        
        for (int i = 1; i < visited.length; i++) {
            if(adjacent[vertex][i] == 1 && !visited[i]) {
                count++;
                dfs(adjacent, visited, i);
            }
        }
        
    }

}
