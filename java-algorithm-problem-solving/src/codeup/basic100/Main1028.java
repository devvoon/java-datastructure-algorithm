package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1028 : [기초-데이터형] 정수 1개 입력받아 그대로 출력하기2(설명) 
 * 
 * @references https://codeup.kr/problem.php?id=1028
 * @author iamdawoonjeong
 */
public class Main1028 {

    public static void main(String[] args) throws IOException {
        
        //입력되는 정수의 범위는 0 ~ 4294967295 
        //int 형 : 2147483648 ~ +2147483647 
        //unsigned int  :   0 ~ 4294967295 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseUnsignedInt(br.readLine());
        System.out.println(Integer.toUnsignedLong(n));

    }

}
