package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1041 : [기초-산술연산] 문자 1개 입력받아 다음 문자 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1041
 * @author iamdawoonjeong
 */
public class Main1041 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char input = br.readLine().charAt(0);
        int toInt = (int)input;
        int next = toInt+1;
        char nextCh = (char)next;
        System.out.println(nextCh);
    }

}
