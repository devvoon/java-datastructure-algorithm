package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1022 : [기초-입출력] 문장 1개 입력받아 그대로 출력하기(설명) 
 * 
 * @references https://codeup.kr/problem.php?id=1021
 * @author iamdawoonjeong
 */
public class Main1022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
    }

}
