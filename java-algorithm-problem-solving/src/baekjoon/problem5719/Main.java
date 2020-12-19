package baekjoon.problem5719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  5719 거의 최단 경로 - 메모리 초과로 실패
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/5719
 */
public class Main {

    public static int[][] adjacent;
    public static int[] distance;
    public static boolean[][] dropped;
    public static int n, m = 0;
    public static ArrayList<Integer>[] list;
    public static int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  //start  node
            int end = Integer.parseInt(st.nextToken());  //end node
            
            distance = new int[n];
            Arrays.fill(distance, INF);
            
            adjacent = new int[n][n];
            list = new ArrayList[n];
            
            for (int i = 0; i < n; i++) {
                Arrays.fill(adjacent[i], -1);
                list[i] = new ArrayList<>();
            }
            
            dropped = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dropped[i], false);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());  //start node
                int v = Integer.parseInt(st.nextToken());  //end node
                int p = Integer.parseInt(st.nextToken());  //start -> end cost
                adjacent[u][v] = p;
            }

            dijkstra(start, end);
            bfs(start, end); // 최단경로 삭제 
            
            Arrays.fill(distance, INF);  //초기화
            dijkstra(start, end); // 최단경로 삭제 후 재탐색
            
            if (distance[end] != INF) {
                sb.append(distance[end] + "\n");
            }else {
                sb.append(-1 + "\n");
            }

        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, distance[start] = 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int cost = node.cost;
            
            if (distance[node.index] < node.cost){
                continue;
            }
            
            for (int i = 0; i < n; i++) {
                
                if (adjacent[index][i] != -1 && cost + adjacent[index][i] <= distance[i] && !dropped[index][i]) {
                    pq.offer(new Node(i, distance[i] = cost + adjacent[index][i]));
                    list[i].add(index);
                }
            }
            
        }
    }
    
    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>(); // 최단경로 담기
        queue.offer(end);  //도착지점 부터 최단 경로 삭제함 
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(now == start) {
                continue;
            }

            for (Integer prev : list[now]) {
           
                if ( adjacent[prev][now] != -1 && distance[now] == adjacent[prev][now] + distance[prev]) {
                    queue.offer(prev);
                    adjacent[prev][now]  = -1; //최단 경로 삭제
                    dropped[prev][now] = true; //삭제된 경로 탐색하지 않게 하기위해 true
                }
                
            }
        }
    }
    
}

class Node implements Comparable<Node> {
    int index, cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}