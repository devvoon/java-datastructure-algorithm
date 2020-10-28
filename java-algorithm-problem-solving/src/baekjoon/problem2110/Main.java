package baekjoon.problem2110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2110 공유기 설치
 * 
 * @reference https://www.acmicpc.net/problem/2110
 * @author iamdawoonjeong
 *
 */
public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            String[] input = br.readLine().split(" ");
            
            int N = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i]=Integer.parseInt(br.readLine());
            }
            
            br.close();
            isr.close();
            
            // 오름차순 정렬
            Arrays.sort(arr);
            
            int start  = 1;             // 최소 gap 
            int end = arr[N-1]-arr[0];  // 최대 gap

            int result = 0;
            
            while(start <= end ) {
                int mid = (start+end)/2;  // (최소갭 + 최대갭)/2 = 공유기 사이 간격 
                int value = arr[0];  // 맨첫번째 집에 공유기 설치 
                int count = 1;  //공유기 설치 함 
                
                for (int i = 1; i < N; i++) {
                    
                    //  공유기 설치할 곳 >= 이전에 바로 공유기 설치한 곳 + 공유기 사이 간격
                    if (arr[i] >= value + mid) {
                        //공유기 설치
                        value= arr[i];
                        // 공유기 설치 갯수 증가
                        count++;
                    }
                }

                if (count >= C ) {
                    //공유기 수를 줄어야 함 : 최대 갭을 늘려 공유기 사이간격 늘이기
                    start = mid + 1;
                    result = mid;
                }else{
                    //공유기 수를 늘여야하는 경우 : 최대 갭 줄여 공유기 사이간격 줄이기 
                    end = mid-1;
                }
            }
            
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        

    }

}
