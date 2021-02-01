package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1027 : [기초-입출력] 년월일 입력 받아 형식 바꿔 출력하기(설명) 
 * 
 * @references https://codeup.kr/problem.php?id=1027
 * @author iamdawoonjeong
 */
public class Main1027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\.");
        
        System.out.print(String.format("%02d", Integer.parseInt(input[2])) + "-");
        System.out.print(String.format("%02d", Integer.parseInt(input[1])) + "-");
        System.out.print(String.format("%4d", Integer.parseInt(input[0])));

    }

}
