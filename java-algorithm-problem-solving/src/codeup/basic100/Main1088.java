package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1088 : [기초-종합] 3의 배수는 통과?(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1088
 * @author iamdawoonjeong
 */
public class Main1088 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i < n+1; i++) {
            if (i%3 ==0) {
                continue;
            }
            System.out.print(i + " ");
            
        }

    }

}
