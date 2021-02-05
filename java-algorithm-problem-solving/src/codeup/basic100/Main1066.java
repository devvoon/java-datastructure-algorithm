package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1066 : [기초-조건/선택실행구조] 정수 3개 입력받아 짝/홀 출력하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1066
 * @author iamdawoonjeong
 */
public class Main1066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        if ( a%2 == 0 ) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }
        
        if ( b%2 == 0 ) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }
        
        if  ( c%2 == 0) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }

    }

}
