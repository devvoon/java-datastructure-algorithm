package baekjoon.sortNumbers10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 10989 수 정렬하기3
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/10989
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001]; //문제의 10000까지의 자연수가 들어간다고 함
        
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[number] += 1; 
        }
        
        for (int i = 1; i < 10001; i++) {
            while(arr[i] > 0){
                bw.write(i+"\n");
                arr[i]--;
            }
        }
        
        bw.flush();
        bw.close();
        osw.close();
        
        br.close();
        isr.close();

    }

}
