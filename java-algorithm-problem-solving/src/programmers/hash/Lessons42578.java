package programmers.hash;

import java.util.HashMap;

/**
 * 42578 위장
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42578
 * @author iamdawoonjeong
 */
public class Lessons42578 {

    public static void main(String[] args) {
        
        String[][] clothes = new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = solution(clothes);
        
        System.out.print(answer);
    }
    
    public static int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], 1);
            }else {
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
        }
      
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }

        return answer-1;
    }

}
