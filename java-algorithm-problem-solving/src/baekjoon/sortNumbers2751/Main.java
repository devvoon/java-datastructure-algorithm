package baekjoon.sortNumbers2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 2751 수 정렬하기 2
 * 
 * @references https://www.acmicpc.net/problem/2751
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            BufferedWriter bw = new BufferedWriter(osw);
            
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(br.readLine())); 
            }
            
            Collections.sort(list);
            for (int i : list) {
               bw.write(i+"\n");
            }
            
            bw.flush();
            bw.close();
            osw.close();
            
            br.close();
            isr.close();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      

    }

}
