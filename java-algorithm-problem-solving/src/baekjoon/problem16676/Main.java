package baekjoon.problem16676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 16676 근우의 다이어리 꾸미기
 * 
 * @references https://www.acmicpc.net/problem/16676
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        int length = n.length();
        
        String max = "" ;
        for (int i = 0; i < length; i++) {
            max = max.concat("1");
        }
        
        if (length == 1) {
            System.out.println(1);
        }else if ( Integer.parseInt(n) >= Integer.parseInt(max)) {
            System.out.println(length);
        }else {
            System.out.println(length-1);
        }
    }

} 
