package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1039 : [기초-산술연산] 정수 2개 입력받아 합 출력하기2(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1039
 * @author iamdawoonjeong
 */
public class Main1039 {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += Long.parseLong(input[i]);
        }
        
        System.out.println(sum);
    }

}
