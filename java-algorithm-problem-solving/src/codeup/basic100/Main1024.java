package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1024 : [기초-입출력] 단어 1개 입력받아 나누어 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1024
 * @author iamdawoonjeong
 */
public class Main1024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        
        for (int i = 0; i < input.length; i++) {
            System.out.println("'"+input[i]+"'");
        }

    }

}
