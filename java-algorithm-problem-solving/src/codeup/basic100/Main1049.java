package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1049 : [기초-비교연산] 두 정수 입력받아 비교하기1(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1049
 * @author iamdawoonjeong
 */
public class Main1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if (a > b) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

}
