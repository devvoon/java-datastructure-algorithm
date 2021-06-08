package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 42587 프린터 - queue 사용
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42587
 * @author iamdawoonjeong
 */
public class Lessons42587s2 {

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 3, 2}; // {7,1,5,6};//{1,1,9,1,1,1}; //
        int location = 2 ; // 2; //0; //
        
        int answer = solution(input, location);
        System.out.println(answer);
    }
    
    public static int solution(int[] priorities, int location) {
        int answer = 0; //출력횟수
        
        //queue에 대기문서 목록을 넣어 줌 
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (Integer priority : priorities) {
            queue.add(priority);
        }
        
        Arrays.sort(priorities);
   
        int index = location;
        int maxIndex = priorities.length-1;
        
        while (!queue.isEmpty()) {
            
            // 1. 출력되는 경우 
            if ( queue.peek() == priorities[maxIndex-answer] ) {
                queue.poll();
                answer+=1;
                
                if (index == 0) {
                    queue.clear();
                    break;
                }else {
                    index--;
                }
                
            }else {
             // 2. 출력되지 않는 경우
               queue.add(queue.poll());
               
               // 내가찾아야하는 문서가 다시 맨뒤로 가야하면, index값 재조정
               if ( index == 0) {
                   //맨뒤로 가야하니 현 queue사이즈에서 -1 
                   index = queue.size()-1;
               }else {
                   index--;
               }
            }
        }
        
        return answer;
    }
}
