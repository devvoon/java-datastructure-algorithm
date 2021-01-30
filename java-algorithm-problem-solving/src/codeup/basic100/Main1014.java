package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1014 : [기초-입출력] 문자 2개 입력받아 순서 바꿔 출력하기(설명) 
 * 
 * @references https://codeup.kr/problem.php?id=1014
 * @author iamdawoonjeong
 */
public class Main1014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        for (int i = str.length-1; i >= 0; i--) {
            System.out.print(str[i]+ " ");
        }

    }

}
