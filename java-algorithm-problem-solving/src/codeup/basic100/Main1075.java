package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1075 : [기초-반복실행구조] 정수 1개 입력받아 카운트다운 출력하기2(설명)    
 *  
 * @references https://codeup.kr/problem.php?id=1075
 * @author iamdawoonjeong
 */
public class Main1075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        do {
            n--;
            System.out.println(n);
        } while (n>0);

    }

}
