package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1035 : [기초-출력변환] 16진 정수 1개 입력받아 8진수로 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1035
 * @author iamdawoonjeong
 */
public class Main1035 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int toHex = Integer.valueOf(input, 16); //16진수로 바꾸어 입력 
        System.out.println(toHex);
        System.out.println(Integer.toOctalString(toHex)); //8진수로 출력 
    }

}
