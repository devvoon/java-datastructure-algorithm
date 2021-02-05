package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1067 : [기초-조건/선택실행구조] 정수 1개 입력받아 분석하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1067
 * @author iamdawoonjeong
 */
public class Main1067 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if ( n > 0 ) {
            System.out.println("plus");
        }else {
            System.out.println("minus");
        }
        
        if ( n%2 == 0 ) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }

    }

}
