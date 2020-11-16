package baekjoon.problem2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 2212 센서 
 * 
 * @references https://www.acmicpc.net/problem/2212
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //센서의 갯수 
        int k = Integer.parseInt(br.readLine()); //집중국의 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //집중국의 갯수가 센서의 갯수보다 크거나 같으면
        if (k >= n) {
            //0출력하고 종료
            System.out.println(0);
            return;
        }
        
        // 집중국의 좌표
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순 정렬 
        Arrays.sort(arr);
        
        // 집중국간의 거리 계산
        Integer[] distances = new Integer[n-1];
        for (int i = 0; i < arr.length-1; i++) {
            distances[i] = arr[i+1] - arr[i] ;
        }
        
        // 집중국 간의 거리를 내림차순으로 정렬 
        Arrays.sort(distances, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        
        // 거리 중 가장 긴 거리 중 센서의 갯수에 맞게 k-1 개를 0으로 셋팅 하여 가장 먼 거리를 지워버림
        for (int i = 0; i < k-1; i++) {
            distances [i]=0;
        }
        
        // 남은 센서간의 거리 합 계산
        int sum = 0;
        for (Integer integer : distances) {
            sum+=integer;
        }
        System.out.println(sum);
    }

}
