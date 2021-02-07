package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1089 : [기초-종합] 수 나열하기1 
 *  
 * @references https://codeup.kr/problem.php?id=1089
 * @author iamdawoonjeong
 */
public class Main1089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int result = a;
        for (int i = 1; i < d; i++) {
            result +=n;
        }
        
        System.out.println(result);

    }

}
