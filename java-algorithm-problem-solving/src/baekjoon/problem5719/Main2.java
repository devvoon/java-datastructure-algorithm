package baekjoon.problem5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  5719 거의 최단 경로
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/5719
 */
public class Main2 {

    public static ArrayList<Node>[] adjacent;
    public static ArrayList<Node>[] reverseAdjacent;
    public static int[] distance;
    public static boolean[][] dropped;
    public static int INF = 100001;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());  //장소수
            int m = Integer.parseInt(st.nextToken());  //도로수

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
                adjacent[u].add(new Node(v, p));
                reverseAdjacent[v].add(new Node(u, p));
            }
            
            distance = new int[n];
            Arrays.fill(distance, INF);
            
            dropped = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dropped[i], false);
            }
            
            dijkstra(start, end);  //최단거리구하기
            bfs(start, end);       //최단경로에 포함되어있는 간선 추적
            
            Arrays.fill(distance, INF);
            dijkstra(start, end);  //최단거리를 제외한 최단거리구하기
            
            if (distance[end] != INF) {
                sb.append(distance[end] + "\n");
            }else {
                sb.append(-1+"\n");
            }
        }
        
        System.out.println(sb.toString());

    }
    
    
    public static void dijkstra(int start, int end) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        //출발노드의 비용은 0
        distance[start] = 0;
        pq.offer(new Node(start, distance[start]));
        
        //최단경로 찾기 = distacne[] 를 채우는 과정 (bfs와 유사)
        while(!pq.isEmpty()) {
            
            //현재 출발 노드 from
            Node from = pq.poll();
            
            //현재 노드 -> dest로 이동 비용 > dest까지 최단거리 비용보다 크다면 
            if (from.cost > distance[from.dest]) {
                //구할 의미 없음 다음 노드 뽑기
                continue;
            }
            
            //현재 노드에서 연결된 목적지 노드까지의 최소비용 구하기
            for (Node to : adjacent[from.dest]) {
                
                //목적지까지의 최소 비용 > dest까지의 최소 이동비용 + 목적지까지 비용
                if ((distance[to.dest] > distance[from.dest] + to.cost) && !dropped[from.dest][to.dest]) {
                    //목적지까지의 최소 비용 = dest까지의 최소 이동비용 + 현재노드에서 목적지까지 비용
                    distance[to.dest] = distance[from.dest] + to.cost;
                    //목적지노드 pq에 넣어주기
                    pq.offer(new Node(to.dest, distance[to.dest]));
                }
                
            }
        }
        
    }
    
    
    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>(); // 최단경로 담기
        queue.offer(end); //도착지점 부터 최단 경로 삭제함 
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now == start) {
                continue;
            }
            
            //최단경로 역으로 추적
            for (Node prev : reverseAdjacent[now]) {
                if (distance[now] == distance[prev.dest] + prev.cost) {
                    dropped[prev.dest][now] = true; //최단 경로 탐색하지 않게 하기위해 true
                    queue.offer(prev.dest);
                }
            }
        }
        
    }
    
    
    public static class Node implements Comparable<Node>{
        private int dest;
        private int cost;
        
        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }
}
    
   

