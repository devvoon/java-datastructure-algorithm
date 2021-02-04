package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1059 : [기초-비트단위논리연산] 비트단위로 NOT 하여 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1059
 * @author iamdawoonjeong
 */
public class Main1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //비트 단위로 1 -> 0, 0 -> 1로 바꾼 후 그 값을 10진수로 출력한다.
        System.out.println(~n);
    }

}
