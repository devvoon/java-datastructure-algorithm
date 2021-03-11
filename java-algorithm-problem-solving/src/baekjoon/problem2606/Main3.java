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
public class Main3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        int n = Integer.parseInt(br.readLine());  //정점의 갯수 
        int k = Integer.parseInt(br.readLine()); // 연결갯수 
         
        int[][] adjacent= new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacent[a][b] = 1;
            adjacent[b][a] = 1;
            
        }

        int result = bfs(1 , adjacent, visited);
        System.out.println(result);
        
    }

    private static int bfs(int start, int[][] adjacent, boolean[] visited) {

        visited[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        int count = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int i = 0; i < visited.length; i++) {
                if (adjacent[now][i] == 1 && !visited[i]) {
                    count ++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return count;
        
    }

}
