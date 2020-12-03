package baekjoon.problem2484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2484 주사위 네개
 * 
 * @references https://www.acmicpc.net/problem/2484
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //참여하는 사람 수 N
        int[] result = new int[n]; // 결과배열
        StringTokenizer st;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); //주사위를 던진 4개의 숫자 받기

            int[] arr = new int[7];

            Arrays.fill(arr, 0);
            for (int j = 0; j < 4; j++) {
                arr[Integer.parseInt(st.nextToken())] += 1 ;
            }
            
            int reward = 0;
            int max = 0;
            int dup = 0;
            int temp = 0;
            
            for (int j = 1; j < 7; j++) {
                //같은 눈이 4개가 나오면 50,000원+(같은 눈)*5,000원의 상금
                if ( arr[j] == 4 ) {
                    reward = 50000 + (j*5000);
                    break;
                    
                }else if ( arr[j] == 3 ){
                    //10,000원+(3개가 나온 눈)*1,000원의 상금
                    reward = 10000 + (j*1000);
                    break;
                    
                }else if (arr[j]  == 2) {
                    
                    //1,000원+(같은 눈)*100원의 상금
                    reward = 1000 + (j*100);
                    
                    dup++;
                    if (dup == 1) {
                        temp = j;
                    }
                    
                    if (dup == 2 ) {
                        //같은 눈이 2개씩 두 쌍이 나오는 경우에는 2,000원+(2개가 나온 눈)*500원+(또 다른 2개가 나온 눈)*500원의 상금을 받게 됨
                        reward = 2000 + (temp*500) + (j*500); 
                        break;
                    }
     
                }else if (arr[j] == 1) {
                    
                    if (dup == 0 ) {
                        max = Math.max(max, j);
                        // (그 중 가장 큰 눈)*100원
                        reward = max * 100;
                    }

                }
            } 
            result[i] = reward;
        }
        

        Arrays.sort(result);
        System.out.println(result[n-1]);
        
    }

}
