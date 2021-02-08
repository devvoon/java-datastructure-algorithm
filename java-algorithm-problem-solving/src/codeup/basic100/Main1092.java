package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1092 : [기초-종합] 함께 문제 푸는 날(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1092
 * @author iamdawoonjeong
 */
public class Main1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int day = 0;
        
        //최소공배수
        while (true) {
            
            day++;
            if ((day%a == 0) && (day%b == 0) && (day%c == 0)) {
                break;
            }
        }
        
        System.out.println(day);

    }

}
