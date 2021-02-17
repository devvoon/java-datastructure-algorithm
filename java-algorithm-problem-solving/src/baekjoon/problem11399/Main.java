package baekjoon.problem11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //오름차순 정렬
        Arrays.sort(arr);
        
        //각 위치별 대기 시간 구하기
        int[] time = new int[n];
        time[0] = arr[0];
        for (int i = 1; i < n; i++) {
            time[i] = time[i-1] + arr[i];
        }
        
        //대기 총 시간의 합
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += time[i];
        }
        System.out.println(sum);

    }

}
