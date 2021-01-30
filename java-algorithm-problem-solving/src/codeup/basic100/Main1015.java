package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1015 : [기초-입출력] 실수 입력받아 둘째 자리까지 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1015
 * @author iamdawoonjeong
 */
public class Main1015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        float f = Float.parseFloat(str);
        System.out.print(String.format("%.2f", f));

    }

}
