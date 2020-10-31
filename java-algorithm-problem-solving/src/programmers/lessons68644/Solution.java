package programmers.lessons68644;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 68644 두 개 뽑아서 더하기
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
 * @author iamdawoonjeong
 *
 */
public class Solution {

    public static void main(String[] args) {
        
        int[] numbers = new int[] {2,1,3,4,1};
        int[] answer = solution(numbers);
        
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
    
    public static int[] solution(int[] numbers) {
        int[] answer = {};

        HashSet<Integer> set = new HashSet<Integer>();  
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++){
                if ( i < j) {
                    int sum = numbers[i] + numbers[j];
                    set.add(sum);
                }
            }
        }

        answer = new int[set.size()];
        int index=0;
        for (Integer num : set) {
            answer[index] = num;
            index++;
        }
        
        Arrays.sort(answer);
        return answer;
    }

}
