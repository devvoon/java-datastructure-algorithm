package baekjoon.problem1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1927 최소 힙
 * 
 * @references https://www.acmicpc.net/problem/1927
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0 ) {
                
                if (pq.isEmpty()) {
                    System.out.println(0);
                }else {
                    System.out.println(pq.poll());
                }
                
            } else {
                pq.offer(number);
            }
        }
        
        br.close();

    }

}
