package baekjoon.problem1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1461 도서관
 * 
 * @references https://www.acmicpc.net/problem/1461
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        PriorityQueue<Integer> negative = new PriorityQueue<Integer>();
        PriorityQueue<Integer> positive = new PriorityQueue<Integer>();
        
        int max = 0;
        for (int i : arr) {
            if (i > 0 ) {
                positive.add(-i);
                max = Math.max(max, i);
            }else {
                negative.add(i);
                max = Math.max(max, -i);
            }
        }
    
        int result  = 0;
        while ( !negative.isEmpty()) {
            result += negative.peek();
            for (int i = 0; i < m; i++) {
                negative.poll();
            }
        }
        
        while( !positive.isEmpty()) {
            result += positive.peek();
            for (int i = 0; i < m; i++) {
                positive.poll();
            }
        }
        
        result = (-result * 2 ) - max;
        System.out.println(result);

    }

}
