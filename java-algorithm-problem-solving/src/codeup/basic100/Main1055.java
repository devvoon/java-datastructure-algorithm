package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1055 : [기초-논리연산] 하나라도 참이면 참 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1055
 * @author iamdawoonjeong
 */
public class Main1055 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if (a==1 || b==1) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }
}
