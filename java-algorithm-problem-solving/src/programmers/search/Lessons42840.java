package programmers.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 42840 모의고사
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42840
 * @author iamdawoonjeong
 */
public class Lessons42840 {
    public static void main(String[] args) {
        
        int[] answers = new int[] {1,2,3,4,5};
        int[] answer = solution(answers);
        
        for (int i : answer) {
            System.out.println(i);
        }
    }
    
    public static int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<answers.length; i++){
            
            if (answers[i] == a[i%5] ) {
                if (map.containsKey(1)) {
                    map.replace(1, map.get(1)+1);
                }else {
                    map.put(1,1);
                }
            }
            
            if (answers[i] == b[i%8] ) {
                if (map.containsKey(2)) {
                    map.replace(2, map.get(2)+1);
                }else {
                    map.put(2,1);
                }
            }
            
            if (answers[i] == c[i%10] ) {
                if (map.containsKey(3)) {
                    map.replace(3, map.get(3)+1);
                }else {
                    map.put(3,1);
                }
            }
        }
        
        int max = 0;

        for(Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(Integer key : map.keySet()) {
            if (max == map.get(key)) {
                result.add(key);
            }
        }
        
        answer = new int[result.size()];
        
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }

}
