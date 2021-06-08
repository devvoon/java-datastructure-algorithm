package programmers.courses18;

import java.util.HashMap;

/**
 * 1878 나머지한점
 * 
 * @author iamdawoonjeong
 * @reference https://programmers.co.kr/learn/courses/18/lessons/1878
 */
public class Lessons1878 {

    public static void main(String[] args) {
        
        //[[1, 4], [3, 4], [3, 10]]
        int[][] input = new int[][]{{1,4}, {3,4}, {3,10}}; // {7,1,5,6};//{1,1,9,1,1,1}; //
        
        int[] answer = solution(input);
        
        for (int i : answer) {
            System.out.print(i + " ");
        }
        
    }
    
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        for (int i = 0 ; i < v.length ; i++){
 
            if (xMap.containsKey(v[i][0])){
                xMap.replace(v[i][0], xMap.get(v[i][0]) + 1);
            }else {
                xMap.put(v[i][0], 1);
            }
        }

        for (int i = 0 ; i < v.length ; i++){
          
            if (yMap.containsKey(v[i][1])){
                yMap.replace(v[i][1], yMap.get(v[i][1]) + 1);
            }else {
                yMap.put(v[i][1], 1);
            }
        }
        
        for (int key : xMap.keySet()){
            
            int value = xMap.get(key);
            if (value == 1 ){
                answer[0]  = key;
            }
        }
        
        for (int key : yMap.keySet()){
            int value = yMap.get(key);
            if (value == 1 ){
                answer[1] = key;
            }
        }

        return answer;
    }

}
