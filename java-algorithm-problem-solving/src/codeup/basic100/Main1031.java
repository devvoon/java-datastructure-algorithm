package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1031 : [기초-출력변환] 10진 정수 1개 입력받아 8진수로 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1031
 * @author iamdawoonjeong
 */
public class Main1031 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //10진수 8진수 변환 
        System.out.println(Integer.toOctalString(n));
    }

}
