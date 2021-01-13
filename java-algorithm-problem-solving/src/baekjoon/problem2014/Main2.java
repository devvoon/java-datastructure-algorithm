package baekjoon.problem2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 2014 소수의 곱 - hashset 사용시 중복체크는 쉬우나 메모리초과 
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/2014
 */
public class Main2 {

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
            pq.offer((long)arr[i]);
        }
        
        HashSet<Long> set = new HashSet<Long>();//계산되는 수의 중복체크를 위해
        
        int index = 0;
        long  min = 0;
        long limit = (long)Math.pow(2, 31); //메모리초과로 인한 limit 정해주기 
        
        while ( index < n ) {
            min = pq.poll();
            
            //set에 존재하면 중복이므로 넘어가고 다음수 뽑아서 진행
            if (set.contains(min)) {
                continue;
            }
            
            set.add(min);
            index++;
            
            for (Integer it : arr) {
                if (min*it < limit) {
                    pq.offer(min*it);
                }
            }
            
        }
        
        bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

}
