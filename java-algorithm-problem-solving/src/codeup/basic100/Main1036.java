package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1036 : [기초-출력변환] 영문자 1개 입력받아 10진수로 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1036
 * @author iamdawoonjeong
 */
public class Main1036 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0);
        System.out.println((int)ch);
    }

}
