package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1081 : [기초-종합] 주사위를 2개 던지면?(설명)   
 *  
 * @references https://codeup.kr/problem.php?id=1081
 * @author iamdawoonjeong
 */
public class Main1081 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i < a+1; i++) {
            for (int j = 1; j < b+1; j++) {
                System.out.println(i + " " + j);
            }
        }

    }

}
