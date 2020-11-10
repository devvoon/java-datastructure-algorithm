package baekjoon.problem1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1697 숨바꼭질
 * 
 * @references https://www.acmicpc.net/problem/1697
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] adjacent = new int[100001];
        bfs(adjacent, n, k);
        System.out.println(adjacent[k]);

    }
    
    public static void bfs(int[] adjacent, int start, int end) {
        
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                break;
            }
        
           if ( now > 0 && adjacent[now-1] == 0) {
               queue.add(now-1);
               adjacent[now-1] = adjacent[now] + 1;
            }
           
           if ( now < 100000 && adjacent[now+1] == 0) {
               queue.add(now+1);
               adjacent[now+1] = adjacent[now] + 1;
            }
           
           if ( now*2 <= 100000 && adjacent[now*2] == 0) {
               queue.add(now*2);
               adjacent[now*2] = adjacent[now] + 1;
            }
        }
    }

}
