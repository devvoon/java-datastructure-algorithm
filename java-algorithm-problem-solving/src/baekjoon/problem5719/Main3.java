package baekjoon.problem5719;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  5719 거의 최단 경로 - 35%에서 시간초과 dfs
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/5719
 */
public class Main3 {
    
    public static ArrayList<Node3>[] adjacent;
    public static ArrayList<Node3>[] reverseAdjacent;
    public static int[] distance;
    public static boolean[][] dropped;
    public static int INF =  Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());  //장소수 //노드 
            int m = Integer.parseInt(st.nextToken());  //도로수 //edge
            
            if ( n == 0 && m == 0) {
                break;
            }
            
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  //시작점
            int end = Integer.parseInt(st.nextToken());  //도착점
            
            adjacent = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacent[i] = new ArrayList<>();
            }
            
            reverseAdjacent = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                reverseAdjacent[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());  //출발지점
                int v = Integer.parseInt(st.nextToken());  //도착지점
                int p = Integer.parseInt(st.nextToken());  //u->v cost
                adjacent[u].add(new Node3(v,p));
                reverseAdjacent[v].add(new Node3(u, p));
            }
            
            distance = new int[n];
            Arrays.fill(distance, INF);
            
            dropped = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dropped[i], false);
            }

            dijkstra(start, end);  //최단거리구하기
            dfs(start, end);       //최단경로에 포함되어있는 간선 추적
            
            Arrays.fill(distance, INF);
            dijkstra(start, end);  //최단거리구하기
            
            if (distance[end] != INF) {
                sb.append(distance[end] + "\n");
            }else {
                sb.append(-1+"\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int start, int end) {
        
        for (Node3 prev : reverseAdjacent[end]) {
            if(distance[end] == distance[prev.dest] + prev.cost) {
                dropped[prev.dest][end] = true;
                dfs(start, prev.dest);
            }
        }
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node3> pq = new PriorityQueue<>();
        
        distance[start] = 0;
        pq.offer(new Node3(start, distance[start]));
        
        while(!pq.isEmpty()) {
            Node3 now = pq.poll();
            
            if (now.cost > distance[now.dest]) {
                continue;
            }
            
            for (Node3 to : adjacent[now.dest]) {
                if ( (distance[to.dest] >  distance[now.dest] + to.cost) && !dropped[now.dest][to.dest]) {
                    distance[to.dest] = distance[now.dest] + to.cost;
                    pq.offer(new Node3(to.dest, distance[to.dest]));
                }
            }
            
        }

    }
    
}


class Node3 implements Comparable<Node3>{
    int dest;
    int cost;

    Node3(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node3 o) {
        return this.cost - o.cost;
    }
    
}