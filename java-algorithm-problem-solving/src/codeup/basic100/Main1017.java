package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1017 : [기초-입출력] 정수 1개 입력받아 3번 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1017
 * @author iamdawoonjeong
 */
public class Main1017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < 3; i++) {
            System.out.print(n + " ");
        }

    }

}
