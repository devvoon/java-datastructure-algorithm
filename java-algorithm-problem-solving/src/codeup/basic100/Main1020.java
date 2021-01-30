package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1020 : [기초-입출력] 주민번호 입력받아 형태 바꿔 출력하기
 * 
 * @references https://codeup.kr/problem.php?id=1020
 * @author iamdawoonjeong
 */
public class Main1020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replace("-", "");
        System.out.println(str);

    }

}
