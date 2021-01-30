package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1018 : [기초-입출력] 시간 입력받아 그대로 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1018
 * @author iamdawoonjeong
 */
public class Main1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        System.out.println(str);

    }

}
