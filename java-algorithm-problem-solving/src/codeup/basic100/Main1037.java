package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1037 : [기초-출력변환] 정수 입력받아 아스키 문자로 출력하기 
 *  
 * @references https://codeup.kr/problem.php?id=1037
 * @author iamdawoonjeong
 */
public class Main1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println((char)input);
    }

}
