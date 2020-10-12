package baekjoon.sortNumbers10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001]; //문제의 1000이
        
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
