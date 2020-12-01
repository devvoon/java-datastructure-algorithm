package baekjoon.problem15969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 15969 행복
 * 
 * @references https://www.acmicpc.net/problem/15969
 * @author iamdawoonjeong
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
        
        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[n-1];
        
        System.out.println(max-min);

    }

}
