package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1011 : [기초-입출력] 문자 1개 입력받아 그대로 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1011
 * @author iamdawoonjeong
 */
public class Main1011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch);
        }

    }

}
