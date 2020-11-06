package baekjoon.problem1904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1904 01타일
 * 
 * @references https://www.acmicpc.net/problem/1904
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        //1부터 1,000,000 까지의 수
        int[] arr = new int[1000001];
        
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        for (int i = 3; i < n+1; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }
        
        System.out.println(arr[n]);
        
        br.close();

    }

}
