package programmers.lessons42587;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 42587 프린터 - priority queue 사용 
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42587
 * @author iamdawoonjeong
 */
public class Solution {

    public static void main(String[] args) {

        int[] input = new int[]{7,1,5,6};//{1,1,9,1,1,1}; //{2, 1, 3, 2}; // 
        int location =2 ; // 2; //
        
        int answer = solution(input, location);
        System.out.println(answer);

    }
    
    public static int solution(int[] priorities, int location) {
        int answer = 0; //출력횟수
        
        //queue에 대기문서 목록을 넣어 줌 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (Integer priority : priorities) {
            //[3, 2, 2, 1] 이렇게 됨 
            pq.offer(priority);
        }
   
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer+=1;
                    
                    if (location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }
        
        return answer;
    }

}
