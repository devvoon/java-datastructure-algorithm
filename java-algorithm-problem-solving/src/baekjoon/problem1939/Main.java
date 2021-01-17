package baekjoon.problem1939;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  1939 중량제한
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1939
 *
 */
public class Main {
    
    private static ArrayList<Vertex>[] graph ;
    private static int result;
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  //섬의 갯수  : 정점vertex ,노드 
        int m = Integer.parseInt(st.nextToken());  //다리의 갯수  : 연결선 edge

        graph = new ArrayList[n+1];
        
        //입력된 섬의 갯수만큼 정점을 만듦 
        for (int i = 1; i < n+1; i++) {
            //adjacent 
            graph[i] = new ArrayList<Vertex>();
        }
        
        int maxWeight = 1;         //문제에서 가질 수 있는 최소중량 1
        int minWeight = 100000000; //문제에서 가질 수 있는최대중량 1,000,000,000
        
        //입력된 다리의 갯수(m)만큼 정점에 edge 연결
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            //from 에서 to 까지의 중량제한 weight이며, 양방향임
            graph[from].add(new Vertex(to, weight));
            graph[to].add(new Vertex(from, weight));

            //주어진 예에서 섬 사이의 최대/최소 제한중량찾기
            maxWeight= Math.max(maxWeight, weight);
            minWeight= Math.min(minWeight, weight);
        }

        //공장이 있는 두 노드 (startNode -  endNode)
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        
        // 최대중량값 구하기 
        binarySearch(n, startNode, endNode, maxWeight, minWeight );
        System.out.println(result);
        
        br.close();
        
    }
    
    /**
     * binary Search  (최대 중량값 구하기)
     * @param n
     * @param startNode
     * @param endNode
     * @param maxWeight
     */
    static void binarySearch(int n, int startNode, int endNode, int maxWeight, int minWeight) {

        int low = minWeight; 
        int high = maxWeight;

      //binary search로 최대중량 찾기 
        while(low <= high) {
            int mid = (low + high)/2; //현재 중량 mid = 2로 시작 

            //현재 중량으로 이동가능여부 판단 
            if (bfs(n,  mid, startNode, endNode)) {
                //이동 가능하므로 중량 늘리기 
                result = Math.max(result, mid);
                low = mid +1;
            }else {
                //이동 불가하므로 중량 줄이기
                high = mid-1;
            }
        }

    }

    /**
     * 중량에 맞는 경로 찾기 (bfs순회)
     * @param queue
     * @param visited
     * @param mid
     * @param endNode
     * @return
     */
    static boolean bfs(int n, int mid, int startNode, int endNode) {

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean visited[] = new boolean[n+1];
        
        queue.add(startNode);       //출발 공장 추가 (1)
        visited[startNode] = true;  //출발 공장은 방문한걸로 시작
        
        // queue가 empty가 아닐때까지 head를 poll 하여 출력
        while(!queue.isEmpty()) {
            //queue의 head를 출력 (1)
            int head = queue.poll();
            
            //head 부터 트리 순회 
            //graph[1] 의 v.weight = 2, v.weight = 3이 존재 
            for (Vertex v : graph[head]) {
                //정점의 중량이 현재중량 보다 클 경우 통과 가능( v.weight = 2일때) 
                if (v.wieght >= mid) {
                    //poll한 노드가 도착공장인 경우 방문 완료 했음으로 리턴 
                    if (head == endNode) {
                        return true;
                    }
                    
                    //v.end =2 에 방문체크하고 queue에 add
                    if(!visited[v.end]) {
                        //방문여부 체크후 queue에 add
                        visited[v.end] = true;
                        queue.add(v.end);
                    }
                }
            }
        }
        return visited[endNode];
    }   
}

class Vertex{
    int end;
    int wieght;
    
    Vertex(int end, int weight) {
        this.end = end;
        this.wieght = weight;
    }
}

