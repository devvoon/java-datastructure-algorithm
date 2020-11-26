package baekjoon.problem1774;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 1774 우주신과의 교감
 * 
 * @references https://www.acmicpc.net/problem/1774
 * @author iamdawoonjeong
 */
public class Main {

    public static ArrayList<Node> adjacent;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        
        //좌표 정보 받기
        Location[] location = new Location[n+1];
        
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            location[i] = new Location(i, x, y);
        }

        //입력된 좌표로 거리 구하고 Node 만들기
        adjacent = new ArrayList<>();

        for (int i = 1; i < n+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                adjacent.add(new Node(location[i].index, location[j].index, getDistance( location[i],  location[j]))) ;
            }
        }

        //부모정보를 입력 : union 가능한지 체크할 때 사용
        parent = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        
        //주어진 간선 정보를 연결  union 으로 부모가 같은지 확인 후 입력 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        //노드 간의 비용 순으로 정렬 
        Collections.sort(adjacent);
        
        // 결과 입력
        double result = 0;
        
        //크루스칼
        for (Node  node : adjacent) {
            if (find(node.src) != find(node.dest)) {
                union(node.src, node.dest);
                result += node.weight;
            }
        }
        
        //소수점 둘째 자리 까지 출력
        System.out.println(String.format("%.2f", result));

    }

    /**
     * 두 정점(좌표) 간의 거리 구하기
     * @param p1
     * @param p2
     * @return
     */
    public static double getDistance(Location p1, Location p2) {
        double a = Math.abs(p1.x - p2.x);
        double b = Math.abs(p1.y - p2.y);
        
        //sqrt :  square root 
        return Math.sqrt((a*a)+(b*b));
    }

    /**
     * 두개의 정점을 합치는 과정
     * @param parent
     * @param a
     * @param b
     */
    private static void union(int a, int b) {
        //합치기 전에  find 함수를 수행해서 두개의 부모가 같은지 확인 
        a = find(a);
        b = find(b);
        
        // 부모가 같지 않다면 입력
        if ( a != b) {
            parent[b] = a;
        }
        
    }

    /**
     * 간선정보의 최상의 부모 정보를 찾음
     * @param a
     * @return
     */
    private static int find(int a) {
        if ( a == parent[a]) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }

}

/**
 * node class
 *
 */
class Node implements Comparable<Node>{
    public int src, dest;
    public double weight;

    Node(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int compareTo(Node o) {
        if (weight < o.weight) {
            return -1;
        }
        return 1;
    }
}

/**
 * location class
 *
 */
class Location{
    int index;
    double x, y;
    
    Location(int index, double x, double y){
        this.index = index;
        this.x = x;
        this.y = y;
    }
    
}

