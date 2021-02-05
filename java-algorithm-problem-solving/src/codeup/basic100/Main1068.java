package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1068 : [기초-조건/선택실행구조] 정수 1개 입력받아 평가 출력하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1068
 * @author iamdawoonjeong
 */
public class Main1068 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  =  Integer.parseInt(br.readLine());
        
        if ( n >= 90) {
            System.out.println("A");
        }else if ( n >= 70) {
            System.out.println("B");
        }else if ( n >= 40) {
            System.out.println("C");
        }else {
            System.out.println("D");
        }

    }

}
