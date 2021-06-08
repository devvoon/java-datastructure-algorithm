package programmers.sort;

import java.util.Arrays;

/**
 * 42746 가장큰수
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42746
 * @author iamdawoonjeong
 */
public class Lessons42746 {


    public static void main(String[] args) {
        
        int[] numbers = new int[] {3, 30, 34, 5, 9};//{6, 10, 2};
        String result = solution(numbers);
        System.out.println(result);
    }
    
    
    public static String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2)->(o2 + o1).compareTo(o1 + o2));
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
    
        answer = sb.toString();
        
        return answer;
    }

}
