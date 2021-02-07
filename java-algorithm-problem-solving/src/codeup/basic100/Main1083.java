package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1083 : [기초-종합] 3 6 9 게임의 왕이 되자!(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1083
 * @author iamdawoonjeong
 */
public class Main1083 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n+1; i++) {
            if (i%3 == 0) {
                System.out.print("X" + " ");
            }else {
                System.out.print(i+ " ");
            }
            
        }
    }

}
