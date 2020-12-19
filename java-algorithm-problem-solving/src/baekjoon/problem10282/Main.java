package baekjoon.problem10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *  10282 해킹
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/10282
 */
public class Main {

    public static ArrayList<Node>[] adjacent;
    public static int[] distance ; 
    public static int INF = Integer.MAX_VALUE;
    public static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수 n : node
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수 d : edge
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호 c :star node
            
            adjacent = new ArrayList[n+1];
            
            for (int j = 1; j < n+1; j++) {
                adjacent[j] = new ArrayList<>();
            }
            
            distance =  new int[n+1];
            Arrays.fill(distance, INF);  //dijkstra는 INF로 채워주고 시작
            count = 1;
            
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());  // 컴퓨터 a가 : from 
                int b = Integer.parseInt(st.nextToken());  // 컴퓨터 b를 의존  : to 
                int s = Integer.parseInt(st.nextToken());  // 컴퓨터 b가 감염되면, s초 후 컴퓨터 a도 감염됨 : weight
                adjacent[b].add(new Node(a,s));
            }
            
            dijkstra(c);
            
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int element : distance) {
                if (element != INF) {
                    result.add(element);
                }
            }
            Collections.sort(result);
            //감염되는 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간 출력
            System.out.println(count + " " + result.get(result.size()-1));
        }
    }
    
    public static void dijkstra(int start){
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
                if (distance[to.dest] > distance[from.dest] + to.cost) {
                    // 목적지 노드비용이 초기값이면 
                    if (distance[to.dest] == INF) {
                        // 방문
                        count++;
                    }
                    
                    //목적지까지 최소비용 = dest까지의 최소이동 비용+ 현재노드에서 목적지까지 비용
                    distance[to.dest] = distance[from.dest] + to.cost;
                    //목적지노드 pq에 넣어주기
                    pq.offer(new Node(to.dest, distance[to.dest]));
                }
            }
            
        }
        
    }
    
    public static class Node implements Comparable<Node>{
        private int dest;  // 노드에 연결된 목적지 노드 
        private int cost;  // 목적지(dest)까지의 비용
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

