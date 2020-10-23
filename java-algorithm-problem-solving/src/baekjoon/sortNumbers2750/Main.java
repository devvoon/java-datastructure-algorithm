package baekjoon.sortNumbers2750;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2750 수 정렬하기 - bubble sort 구현
 * 
 * @reference https://www.acmicpc.net/problem/2750
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args)  {
        
        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int n = Integer.parseInt(br.readLine());
            int numbers[] = new int[n];
            
            for (int i = 0; i < n; i++) {
                numbers[i]=Integer.parseInt(br.readLine());
            }
            
            int result[] = new int[n];
            result = solution(numbers);

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 버블 정렬 구현 (bubble sort)
     * @param numbers
     * @return
     */
    private static int[] solution(int[] numbers) {

        boolean swaped = false;
        for (int i = 0; i < numbers.length -1; i++) {

            swaped = false;
            for (int j = 0; j < numbers.length-1-i; j++) {
                //swap
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swaped = true;
                }
            }
            
            if (!swaped){
                break;
            }
        }
        
        return numbers;
        
    }
}
