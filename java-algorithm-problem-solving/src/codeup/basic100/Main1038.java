package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1038 : [기초-산술연산] 정수 2개 입력받아 합 출력하기1(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1038
 * @author iamdawoonjeong
 */
public class Main1038 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //입력 두숫자 범위 :  -1073741824 ~ 1073741824 
        String[] input = br.readLine().split(" ");
        
        long sum = 0; // long : -9,223,372,036,854,775,808(-2^63) ~ 9,223,372,036,854,775,807(2^63 -1) |
        for (int i = 0; i < input.length; i++) {
            sum += Integer.parseInt(input[i]);
        }
        System.out.println(sum);

    }

}
