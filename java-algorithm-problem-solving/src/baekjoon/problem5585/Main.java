package baekjoon.problem5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5585 거스름돈
 * 
 * @references https://www.acmicpc.net/problem/5585
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int changes = 1000 - n;
        int[] coins = new int[]{500,100,50,10,5,1};  // 500엔, 100엔, 50엔, 10엔, 5엔, 1엔
        int count = 0;
        
        for (int i = 0; i < coins.length; i++) {
            if( changes >= 0 ) {
                count = count + (changes/coins[i]);
                changes %= coins[i];
            }
        }

        System.out.println(count);
    }

}
