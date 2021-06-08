package programmers.sort;

import java.util.Arrays;


/**
 * 42748 K번째수
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42748
 * @author iamdawoonjeong
 */
public class Lessons42748 {

    public static void main(String[] args) {

        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        
        int[] answer = solution(array, commands);
        
        for (int i : answer) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        

        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k  = commands[n][2];
            
            int[] subArr = new int[j-i+1];
            int index = 0;
            
            for (int start = i-1; start < j ; start++) {
                subArr[index] = array[start];
                index++;
            }
            
            Arrays.sort(subArr);
            answer[n]= subArr[k-1];
            
        }
        return answer;
    }

}


