package baekjoon.problem1766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1766 문제집
 * 
 * @references https://www.acmicpc.net/problem/1766
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());   //문제의 갯수, 난이도
        int m = Integer.parseInt(st.nextToken());   //어떤 문제를 먼저 푸는 것이 좋은가
    
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        int[] indegree  = new int[n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            //A번 문제는 B번 문제보다 먼저 푸는 것이 좋다는 의미
            list[a].add(b);
            //B번 문제는 간선이 추가됨 
            indegree[b] += 1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 1; i <= n; i++) {
            //진입차수가 0 -> 시작 노드
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while(!pq.isEmpty()) {
            
            //진입차수가 0인 node 를 먼저 뽑고 
            int node = pq.poll();
            result.add(node);
            
            //해당 node에 연결된 간선 체크
            for (int i = 0; i < list[node].size(); i++) {
                //연결된 노드확인 
                int y = list[node].get(i);
                //간선제거
                indegree[y] -= 1;
                if ( indegree[y] == 0) {
                    pq.add(y);
                }
            }
        }
        
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

        br.close();

    }

}
