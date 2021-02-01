package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1023 : [기초-입출력] 실수 1개 입력받아 부분별로 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1021
 * @author iamdawoonjeong
 */
public class Main1023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\.");
        System.out.println(input[0]);
        System.out.println(input[1]);
    }

}
