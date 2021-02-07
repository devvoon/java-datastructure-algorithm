package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1087 : [기초-종합] 여기까지! 이제 그만~(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1087
 * @author iamdawoonjeong
 */
public class Main1087 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int index=0;
        while(sum < n) {
            index++;
            sum+=index;
        }
        
        System.out.println(sum);

    }

}
