package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1078 : [기초-종합] 짝수 합 구하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1078
 * @author iamdawoonjeong
 */
public class Main1078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        for (int i = 1; i < n+1; i++) {
            if (i % 2 ==0 ) {
                sum+=i;
            }
        }
        System.out.println(sum);

    }

}
