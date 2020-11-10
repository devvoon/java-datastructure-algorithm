package baekjoon.problem1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1260 DFS와 BFS
 * 
 * @references https://www.acmicpc.net/problem/1260
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());  //vertex
        int m = Integer.parseInt(st.nextToken());  //edge
        int v = Integer.parseInt(st.nextToken());  //start node
        
        boolean visited[] = new boolean[n+1];
        int[][] adjacent = new int[n+1][n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjacent[from][to] = 1;
            adjacent[to][from] = 1;
        }
        
        dfs(adjacent, visited, n);
        System.out.println();
        //visited  초기화 
        Arrays.fill(visited, false);
        bfs(adjacent, visited, n);

    }
    
    public static void dfs(int[][] adjacent, boolean[] visited, int vertex) {
        
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (int i = 1; i < visited.length; i++) {
            if(adjacent[vertex][i] == 1 && !visited[i]) {
                dfs(adjacent, visited, i);
            }
        }
    }
    
    public static void bfs(int[][] adjacent, boolean[] visited, int vertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        visited[vertex] = true;
        queue.add(vertex);
        
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print( vertex + " ");
            
            for (int i = 1; i < visited.length; i++) {
                if(adjacent[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    
}