package baekjoon.problem1781;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1781 컵라면
 * 
 * @references https://www.acmicpc.net/problem/1781
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st ;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if ( o1[0] == o2[0] ) {
                    return Integer.compare(o1[1], o2[1]);
                }else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        int result = 0 ;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            int deadline = arr[i][0];  //데드라인 
            queue.add(arr[i][1]); //컵라면 갯수 
            if (deadline < queue.size()) {
                queue.poll();
            }
        }
        
        for (Integer integer : queue) {
            result += integer;
        }
        
        System.out.println(result);
    }

}
