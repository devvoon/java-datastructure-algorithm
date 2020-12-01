package baekjoon.problem10539;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  10539 수빈이와 수열
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/10539
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] result = new int[n];
        result[0] = arr[0];  //초기값
        int sum = result[0];
        for (int i = 1; i < n; i++) {
            result[i] = (i+1)*arr[i] -  sum;
            sum += result[i];
        }
        
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
