package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1012 : [기초-입출력] 실수 1개 입력받아 그대로 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1012
 * @author iamdawoonjeong
 */
public class Main1012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine() ;
        float f = Float.parseFloat(str);
        
        System.out.print(String.format("%.6f", f));
    }

}
