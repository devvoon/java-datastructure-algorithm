package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1080 : [기초-종합] 언제까지 더해야 할까?   
 *  
 * @references https://codeup.kr/problem.php?id=1080
 * @author iamdawoonjeong
 */
public class Main1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        
        int index = 0;
        int sum = 0;
        while (sum < input) {
            index++;
            sum+=index;
        }
        System.out.println(index);

    }

}
