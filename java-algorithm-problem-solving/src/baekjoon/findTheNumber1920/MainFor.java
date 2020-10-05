package baekjoon.findTheNumber1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1920 수 찾기
 * 
 * [문제]
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
 * 다음 줄에는 M(1≤M≤100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
 * 모든 정수의 범위는 -2의 31제곱 보다 크거나 같고 2의 31제곱 보다 작다.
 * 
 * [출력]
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 * 
 * [예제]
 * 5
 * 4 1 5 2 3
 * 5
 * 1 3 7 9 5
 * ->
 * 1
 * 1
 * 0
 * 0
 * 1
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
                //System.out.println(temp[i]);
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
