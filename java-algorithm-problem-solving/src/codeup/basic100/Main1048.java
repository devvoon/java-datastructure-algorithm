package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1048 : [기초-비트시프트연산] 한 번에 2의 거듭제곱 배로 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1048
 * @author iamdawoonjeong
 */
public class Main1048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //System.out.println(a * (int)Math.pow(2, b));
        int result = (a << b);
        System.out.println(result);

    }

}
