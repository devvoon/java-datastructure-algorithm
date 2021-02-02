package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1034 : [기초-출력변환] 8진 정수 1개 입력받아 10진수로 출력하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1034
 * @author iamdawoonjeong
 */
public class Main1034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(Integer.valueOf(input, 8)); //8 진수로 입력받아 10진수로 출력 
    }

}
