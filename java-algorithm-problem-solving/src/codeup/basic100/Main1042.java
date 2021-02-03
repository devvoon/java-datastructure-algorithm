package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1042 : [기초-산술연산] 정수 2개 입력받아 나눈 몫 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1042
 * @author iamdawoonjeong
 */
public class Main1042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        float result = a/b;
        System.out.println((int)result);
    }

}
