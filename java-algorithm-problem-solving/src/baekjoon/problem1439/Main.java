package baekjoon.problem1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1439 뒤집기
 * 
 * @references https://www.acmicpc.net/problem/1439
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        
        int count0 = 0;
        int count1 = 0;
        
        if (arr[0] == 1) {
            count0 += 1;
        }else {
            count1 += 1;
        }
        
        for (int i = 0; i < arr.length-1; i++) {

            if (arr[i] != arr[i+1]) {
                if(arr[i+1] == 1 ) {
                    count0 += 1;
                }else {
                    count1 += 1;
                }
            }
        }
        
        int result = Math.min(count0, count1);
        System.out.println(result);

    }

}
