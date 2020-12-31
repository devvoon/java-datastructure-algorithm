package baekjoon.problem10802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = 0; 
        for (int i = start ; i <= end; i++) {
        
            if ( (i%3 == 0) || (Integer.toString(i).indexOf("3") != -1) ||  (Integer.toString(i).indexOf("6") != -1) ||  (Integer.toString(i).indexOf("9") != -1) ) {
                count+=1;
            }
        }
        
        System.out.println(count);
        br.close();

    }

}
