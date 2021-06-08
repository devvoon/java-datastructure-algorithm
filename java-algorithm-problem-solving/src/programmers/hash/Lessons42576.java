package programmers.hash;

import java.util.HashMap;

/**
 * 42576 완주하지 못한 선수
 * 
 * @author iamdawoonjeong
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Lessons42576 {

    public static void main(String[] args) {
    
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        
        String answer = solution(participant, completion);
        System.out.println(answer);
    }
    
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.replace(participant[i], map.get(participant[i])+1);
            }else {
                map.put(participant[i], 1);
            }
        }
        
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                map.replace(completion[i], map.get(completion[i])-1);
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) > 0 ) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }

}
