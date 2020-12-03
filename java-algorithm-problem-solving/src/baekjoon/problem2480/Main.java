package baekjoon.problem2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2480 주사위 세개
 * 
 * @references https://www.acmicpc.net/problem/2480
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[7];
        Arrays.fill(arr, 0);
        for (int i = 0; i < 3; i++) {
            arr[Integer.parseInt(st.nextToken())] += 1 ;
        }
        
        int reward = 0;
        int max = 0;
        
        for (int i = 1; i < 7; i++) {

            if (arr[i] == 3) {
                // 10,000원+(같은 눈)*1,000원
                reward = 10000 + (i*1000);
                break;
                
            }else if (arr[i] == 2) {
                //1,000원+(같은 눈)*100원
                reward = 1000 + (i*100);
                break;
                
            }else if (arr[i] == 1) {
                //(그 중 가장 큰 눈)*100원의 상금
                max = Math.max(i, max);
                reward = max*100;
            }
        }
        
        System.out.println(reward);

    }

}
