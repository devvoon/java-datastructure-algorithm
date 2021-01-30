package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * 1019 : [기초-입출력] 연월일 입력받아 그대로 출력하기
 * 
 * @references https://codeup.kr/problem.php?id=1019
 * @author iamdawoonjeong
 */
public class Main1019 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\.");

        System.out.println(String.format("%04d", Integer.parseInt(input[0])) + "." + String.format("%02d", Integer.parseInt(input[1])) + "." + String.format("%02d", Integer.parseInt(input[2])) );

    }

}
