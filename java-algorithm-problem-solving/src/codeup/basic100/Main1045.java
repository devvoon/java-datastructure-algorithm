package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1045 : [기초-산술연산] 정수 2개 입력받아 자동 계산하기
 *  
 * @references https://codeup.kr/problem.php?id=1045
 * @author iamdawoonjeong
 */
public class Main1045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int sum = a+b;
        int sub = a-b;
        int mul = a*b;
        int por = a/b;
        int mod = a%b;
        float porf = ((float)a/(float)b);
        
        System.out.println(sum);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(por);
        System.out.println(mod);
        System.out.println(String.format("%.2f", porf));
    }

}

