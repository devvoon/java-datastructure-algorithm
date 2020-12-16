package baekjoon.problem2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2606 바이러스 - bfs 
 * 
 * @references https://www.acmicpc.net/problem/2606
 * @author iamdawoonjeong
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int[][] adjacent = new int[n+1][n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacent[from][to] = 1;
            adjacent[to][from] = 1;
        }
        
        boolean[] visited  = new boolean[n+1];
        
        bfs(adjacent,visited, 1);
        
        int count = 0;
        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static void bfs(int[][] adjacent, boolean[] visited, int vertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(vertex);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int i = 1; i < visited.length; i++) {
                if (adjacent[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
    }

}
