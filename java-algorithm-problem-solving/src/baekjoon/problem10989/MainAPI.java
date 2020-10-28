package baekjoon.problem10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 10989 수 정렬하기3 - API이용
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/10989
 *
 */
public class MainAPI {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        for (int i : arr) {
            bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        osw.close();
        
        br.close();
        isr.close();
        
    }

}
