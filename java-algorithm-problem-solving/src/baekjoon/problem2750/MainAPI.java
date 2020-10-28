package baekjoon.problem2750;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2750 수 정렬하기 - Arrys.sort() 이용
 * 
 * @reference https://www.acmicpc.net/problem/2750
 * @author iamdawoonjeong
 */
public class MainAPI {

    public static void main(String[] args) {

        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int n = Integer.parseInt(br.readLine());
            int numbers[] = new int[n];
            
            for (int i = 0; i < n; i++) {
                numbers[i]=Integer.parseInt(br.readLine());
            }
            
            Arrays.sort(numbers);
            
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
            }
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
