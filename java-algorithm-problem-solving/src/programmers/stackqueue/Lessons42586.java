package programmers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 42586 기능개발
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42586
 * @author iamdawoonjeong
 */
public class Lessons42586 {

    public static void main(String[] args) {
        
        int[] progresses = new int[] {93, 30, 55};
        int[] speeds = new int[] {1, 30, 5};
        
        int[] answer = solution(progresses, speeds);
        
        for (int i : answer) {
            System.out.println(i);
        }
    }
    
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<Integer>();
        int day = 0;
        for (int i = 0; i < progresses.length; i++) {
            int rest = (100- progresses[i]);
            
            if (rest/speeds[i] == 0) {
                day = rest/speeds[i];
            }else {
                day = rest/speeds[i]+1;
            }
            queue.offer(day);
        }
        
        int firstTask = queue.peek();
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int now = queue.peek();
            if (firstTask >= now) {
                count++;
                queue.poll();
            }else {
                list.add(count);
                count=0;
                firstTask = now;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}
