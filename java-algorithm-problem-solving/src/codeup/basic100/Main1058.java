package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1058 : [기초-논리연산] 둘 다 거짓일 경우만 참 출력하기
 *  
 * @references https://codeup.kr/problem.php?id=1058
 * @author iamdawoonjeong
 */
public class Main1058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if (a == 0 &&  b == 0) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }
}
