package baekjoon.problem1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1715 카드 정렬하기
 * 
 * @references https://www.acmicpc.net/problem/1715
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int result = 0;
        while ( !(pq.size() == 1)) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a+b;
            result += sum;
            pq.offer(sum);
        }
        
        System.out.println(result);
        
        br.close();

    }

}
