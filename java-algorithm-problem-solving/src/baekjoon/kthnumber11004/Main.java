package baekjoon.kthnumber11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Integer> list = new LinkedList<Integer>();
            
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken())); 
            }
            
            Collections.sort(list);
            System.out.println(list.get(k-1));
            
            br.close();
            isr.close();
                    
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
