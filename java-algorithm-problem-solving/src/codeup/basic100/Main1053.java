package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1053 : [기초-논리연산] 참 거짓 바꾸기(설명)  
 *  
 * @references https://codeup.kr/problem.php?id=1053
 * @author iamdawoonjeong
 */
public class Main1053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n==1) {
            System.out.println(0);
        }else {
            System.out.println(1);
        }

    }

}
