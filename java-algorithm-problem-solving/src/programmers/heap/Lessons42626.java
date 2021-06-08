package programmers.heap;

import java.util.PriorityQueue;

/**
 * 42626 더 맵게
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42626
 * @author iamdawoonjeong
 */
public class Lessons42626 {
    public static void main(String[] args) {

        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7 ; 
        
        int answer = solution(scoville, K);
        System.out.println(answer);

    }
    
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
            
        }
        
        while(pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            
            int a = pq.poll();
            int b = pq.poll();
            int newK = a + (b*2);
            pq.offer(newK);
            answer++;
        }
        
        return answer;
    }

}
