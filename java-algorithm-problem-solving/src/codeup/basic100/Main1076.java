package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1076 : [기초-반복실행구조] 문자 1개 입력받아 알파벳 출력하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1076
 * @author iamdawoonjeong
 */
public class Main1076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int input = (int)str.charAt(0); 
        char a = 'a';
        int num = (int)a ;//a 97 ~ z 122
        
        while(input >= num) {
            char ch = (char) num;
            System.out.println(ch);
            num++;
        }
    }

}
