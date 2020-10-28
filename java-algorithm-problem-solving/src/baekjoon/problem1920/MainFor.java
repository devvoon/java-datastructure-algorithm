package baekjoon.problem1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1920 수 찾기
 * 
 * @references https://www.acmicpc.net/problem/1920
 * @author iamdawoonjeong
 */
public class MainFor {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            String[] temp= br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }
            
            int M = Integer.parseInt(br.readLine());
            int[] arr2 = new int[M];
            String[] temp2= br.readLine().split(" ");
            
            int[] result = new int[M];
            
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(temp2[i]);
                result[i] = solution(arr, arr2[i]);
            }
            
            for (int j = 0; j < M; j++) {
                System.out.println(result[j]);
            }
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int solution(int[] arr, int input) {
       
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == input )
                return 1;
        }
        return 0;
    }
    }
