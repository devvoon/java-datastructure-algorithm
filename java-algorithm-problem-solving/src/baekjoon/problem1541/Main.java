package baekjoon.problem1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //55-50+40
        String[] input = br.readLine().split("\\-"); //-기준으로 피연산자들 구하기
        //55
        //50+40
        
        int[] sum = new int[input.length]; //숫자들의 합
        
        for (int i = 0; i < input.length; i++) {
            String[] operand = input[i].split("\\+"); //+ 기호 기준으로 피연산자들 구하기 
            
            for (int j = 0; j < operand.length; j++) {
                sum[i] += Integer.parseInt(operand[j]) ;
            }
        }
        
        int result = sum[0];
        for (int i = 1; i < sum.length; i++) {
            result = result - sum[i];
        }
        
        System.out.println(result);

    }

}
