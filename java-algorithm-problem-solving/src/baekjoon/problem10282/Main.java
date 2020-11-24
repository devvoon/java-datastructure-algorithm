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
            System.out.println(count + " " + result.get(result.size()-1));
        }
    }
    
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        distance[start] = 0;
        pq.offer(new Node(start, distance[start]));
        
        while(!pq.isEmpty()) {
            Node from = pq.poll();
            
            if (from.cost > distance[from.index]) {
                continue;
            }
            
            for (Node to : adjacent[from.index]) {
                if (distance[to.index] > distance[from.index] + to.cost) {
                    if (distance[to.index] == INF) {
                        count++;
                    }
                    distance[to.index] = distance[from.index] + to.cost;
                    pq.offer(new Node(to.index, distance[to.index]));
                }
            }
            
        }
        
    }
    
    public static class Node implements Comparable<Node>{
        private int index;
        private int cost;
        
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

