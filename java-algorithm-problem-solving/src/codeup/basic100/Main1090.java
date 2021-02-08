package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1090 : [기초-종합] 수 나열하기2
 *  
 * @references https://codeup.kr/problem.php?id=1090
 * @author iamdawoonjeong
 */
public class Main1090 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        long result = a;
        for (int i = 1; i < n; i++) {
            result *= r;
        }
        
        System.out.println(result);

    }

}
