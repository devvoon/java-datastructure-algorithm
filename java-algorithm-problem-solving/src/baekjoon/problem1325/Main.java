package baekjoon.problem1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1325 효율적인 해킹
 * 
 * @references https://www.acmicpc.net/problem/1325
 * @author iamdawoonjeong
 */
public class Main {

    public static ArrayList<Integer> adjacent[];
    public static int[] result ;
    public static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());  //정점의갯수 
        m = Integer.parseInt(st.nextToken());  //관계갯수 
        
        adjacent = new ArrayList[n+1];
        
        for (int i = 1; i < n+1; i++) {
            adjacent[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());   //A B : A가 B를 신뢰한다 ; B를 해킹하면 A도 해킹 가능
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacent[a].add(b);
        }

        result = new int[n+1];
        StringBuilder sb = new StringBuilder();
        int max =  0;
        
        for (int i = 1; i < n+1; i++) {
            bfs(i);
        }
        
        for (int i = 1; i < n+1 ; i++) {
            max  = Math.max(max, result[i]);
        }

        for (int i = 1; i < n+1 ; i++) {
            if (result[i] ==  max) {
              sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int vertex) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n+1];
        visited[vertex] = true;
        queue.add(vertex);
        
        while(!queue.isEmpty()) {
            int value = queue.poll();

            for (int i = 0; i < adjacent[value].size(); i++) {

                int v = adjacent[value].get(i);
                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    result[v]++;
                }
            }
        }
    }

}
