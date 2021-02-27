package baekjoon.problem10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    
    public static ArrayList<Node>  adjacent[];
    public static int[] distance;
    public static int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adjacent = new ArrayList[n+1];
            for (int j = 0; j < n+1; j++) {
                adjacent[j] = new ArrayList<>();
            }
            
            distance = new int[n+1];
            Arrays.fill(distance, INF);
            
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adjacent[b].add(new Node(a, s));
            }
            
            dijkstra(n,c);
            
            int count = 0;
            int maxDistance= 0;
            
            for (int dis : distance) {
                if (dis != INF) {
                    count++;
                    maxDistance = Math.max(maxDistance, dis);
                }
            }
            
            System.out.println(count + " " + maxDistance);
        }
    }
    
    public static void dijkstra(int n, int start) {
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        
        distance[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, distance[start]));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (distance[now.dest] < now.cost) {
                continue;
            }
            
            for (Node to : adjacent[now.dest]) {
                
                if(distance[to.dest] > distance[now.dest] + to.cost) {
                    distance[to.dest] = distance[now.dest] + to.cost;
                    pq.offer(new Node(to.dest, distance[to.dest]));
                }
            }
        }
        
    }

    public static class Node implements Comparable<Node>{
        private int dest;
        private int cost;
        
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
        
    }

}
