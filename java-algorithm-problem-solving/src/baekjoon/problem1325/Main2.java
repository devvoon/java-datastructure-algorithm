package baekjoon.problem1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1325 효율적인 해킹 - bfs (메모리초과됨)
 * 
 * @references https://www.acmicpc.net/problem/1325
 * @author iamdawoonjeong
 */
public class Main2 {


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] adjacent = new int[n+1][n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacent[b][a] = 1;
        }
        
        int[] result = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            result[i] = bfs(adjacent, n, i);
        }
        
        int max = 0;
        for (int i = 1; i < n+1; i++) {
            max  = Math.max(max, result[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            if (max == result[i]) {
                sb.append( i + " " );
            }
        }
        
        System.out.println(sb);

    }

    public static int bfs(int[][] adjacent, int n, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int i = 1; i < n; i++) {
                if (adjacent[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        
        return count;
        
    }

}
