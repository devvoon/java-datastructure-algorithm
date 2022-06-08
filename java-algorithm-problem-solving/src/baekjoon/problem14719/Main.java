package baekjoon.problem14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int heigth  = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
            
        String[] str = br.readLine().split(" ");
        int[] arr =  new int[width];
        for (int i = 0; i < width; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        
        //첫번째 기둥과 마지막 블록 제외
        for (int i = 1; i < width-1; i++) {
            left = 0;
            right = 0;
           
            // 왼쪽에서 가장 높은 블록
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            
            // 오른쪽에서 가장 높은 블록
            for (int j = i+1; j < width; j++) {
                right = Math.max(right, arr[j]);
            }
            
            if (arr[i] < left && arr[i] < right) {
                sum += Math.min(left, right) - arr[i];
            }
        }
        
        System.out.println(sum);

    }

}
