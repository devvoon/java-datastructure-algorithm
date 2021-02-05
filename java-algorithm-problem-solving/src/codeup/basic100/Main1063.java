package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1063 : [기초-삼항연산] 두 정수 입력받아 큰 수 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1063
 * @author iamdawoonjeong
 */
public class Main1063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = 0 ;
        int b = 0; 
        for (int i = 0; i < input.length; i++) {
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
        }
         
        int result = (a > b ?  a : b);
        System.out.println(result);

    }

}
