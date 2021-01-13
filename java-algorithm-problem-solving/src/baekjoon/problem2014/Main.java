package baekjoon.problem2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 2014 소수의 곱 
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/2014
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[k];
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.offer((long) arr[i]);
        }

        int index = 0; // 중복된수는 index 증가 안시키고 따로 관리하려고 선언
        long min  = 0 ;
        long limit = (long)Math.pow(2, 31); //메모리초과로 인한 limit 정해주기

        while( index < n ) {
            //pq에서 최소수를 뽑고 
            min  = pq.poll();
            
            //인덱스 증가 
            index++;
            
            for (Integer it : arr) {
                
                if ((min*it)  < limit) {
                    pq.offer(min*it);
                }
                
                if (min%it == 0) {
                    //for문 빠져나옴 
                    break;
                }
            }
        }
        
        bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
