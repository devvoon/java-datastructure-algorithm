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
        
        //이전 정점에서 현재 정점까지의 거리를 계산
        int[] arr = new int[100001];
        bfs(arr, n, k);
        System.out.println(arr[k]);

    }
    
    public static void bfs(int[] arr, int start, int end) {
        
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                break;
            }
        
           // 수빈이가 이동할 수 있는 경우의 세가지를 매 노드 마다 체크 
            
           // x-1  이동 : 이동 노드 값이 0보다 크고, 방문한적이 없어야 함
           if ( now > 0 && arr[now-1] == 0) {
               queue.add(now-1);
               arr[now-1] = arr[now] + 1;
            }
           
           // x+1  이동 : 이동 노드 값이 최대값 미만, 방문한적이 없어야 함
           if ( (now+1) < 100000 && arr[now+1] == 0) {
               queue.add(now+1);
               arr[now+1] = arr[now] + 1;
            }
           
           // x*2  이동 : 이동 노드 값이 최대값 이하, 방문한적이 없어야 함
           if ( now*2 <= 100000 && arr[now*2] == 0) {
               queue.add(now*2);
               arr[now*2] = arr[now] + 1;
            }
        }
    }

}
