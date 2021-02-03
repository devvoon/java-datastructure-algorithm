package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1044 : [기초-산술연산] 정수 1개 입력받아 1 더해 출력하기(설명)  
 *  
 * @references https://codeup.kr/problem.php?id=1044
 * @author iamdawoonjeong
 */
public class Main1044 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        n++;
        System.out.println(n);
    }

}
