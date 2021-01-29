package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1010 : [기초-입출력] 정수 1개 입력받아 그대로 출력하기(설명) 
 * 
 * @references https://codeup.kr/problem.php?id=1010
 * @author iamdawoonjeong
 */
public class Main1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n);
    }

}
