package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1079 : [기초-종합] 원하는 문자가 입력될 때까지 반복 출력하기  
 *  
 * @references https://codeup.kr/problem.php?id=1079
 * @author iamdawoonjeong
 */
public class Main1079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < input.length; i++) {
            
           if ("q".equals(input[i])) {
               System.out.println(input[i]);
               break;
           }else {
               System.out.println(input[i]);
           }
        }

    }

}
