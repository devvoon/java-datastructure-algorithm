package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1077 : [기초-반복실행구조] 정수 1개 입력받아 그 수까지 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1077
 * @author iamdawoonjeong
 */
public class Main1077 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        while(n >= start) {
            System.out.println(start);
            start++;
        }
    }

}
