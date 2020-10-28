package baekjoon.problem1472;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1472 소트인사이드 - bubble sort 구현
 * 
 * @reference https://www.acmicpc.net/problem/1472
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            String[] input = br.readLine().split("");
            int[] nubmers = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                nubmers[i] = Integer.parseInt(input[i]);
            }
            
            int[] result= new int[nubmers.length];
            result = solution(nubmers);
            
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
            }
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static int[] solution(int[] numbers) {
        
        boolean swaped = false;
        
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length-1-i; j++) {
                if(numbers[j] < numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swaped=true;
                }
            } 
            
            if(!swaped) {
                break;
            }
            
        }
        return numbers;
        
    }

}
