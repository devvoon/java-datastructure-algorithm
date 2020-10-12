package baekjoon.cordinateAlignment11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 11650 좌표 정렬하기 
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/11650
 *
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" "); 
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return  Integer.compare(o1[1], o2[1]);
                }else 
                    return Integer.compare(o1[0], o2[0]);
                }
        });
        
        for (int[] is : arr) {
            System.out.println(is[0] + " " + is[1]);
        }

        br.close();
        isr.close();
    }

}
