package baekjoon.problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2012 등수 매기기
 * 
 * @reference https://www.acmicpc.net/problem/2012
 * @author iamdawoonjeong
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        long result = 0;
        for (int i = 1; i < arr.length; i++) {
            long gap = Math.abs(i-arr[i]);
            result += gap;
        }
        
        System.out.println(result);

    }

}
