package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1064 : [기초-삼항연산] 정수 3개 입력받아 가장 작은 수 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1064
 * @author iamdawoonjeong
 */
public class Main1064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        //삼항연산자로 세개의 숫자 비교 
        // int result  =( (a > b  ? a : b) > c  ? (a > b ? a : b) : c); // 가장 큰 수
        int result  =( (a < b  ? a : b) < c  ? (a < b ? a : b) : c); // 가장 작은 수 
        System.out.println(result);

    }

}
