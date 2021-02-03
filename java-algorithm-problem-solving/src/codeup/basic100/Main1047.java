package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1047 : [기초-비트시프트연산] 정수 1개 입력받아 2배 곱해 출력하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1047
 * @author iamdawoonjeong
 */
public class Main1047 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        System.out.println(n<<1);
        System.out.println(n>>1);
        System.out.println(n<<2);
        System.out.println(n>>2);
        

    }

}
