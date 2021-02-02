package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1032 : [기초-출력변환] 10진 정수 입력받아 16진수로 출력하기1(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1032
 * @author iamdawoonjeong
 */
public class Main1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(Integer.toHexString(n));

    }

}
