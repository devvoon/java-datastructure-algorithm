package programmers.sort;

import java.util.Arrays;

/**
 * 42747 H-Index
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42747
 * @author iamdawoonjeong
 */
public class Lessons42747 {

    public static void main(String[] args) {
        
        int[] citations = new int[] {3, 0, 6, 1, 5};
        int result = solution(citations);
        System.out.println(result);
    }
    
    
    public static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations); //6 5 3 1 0
        
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            System.out.println(h);
            if (citations[i]>=h) {
                answer = h;
                break;
            }
        }
                
        return answer;
    }

}
