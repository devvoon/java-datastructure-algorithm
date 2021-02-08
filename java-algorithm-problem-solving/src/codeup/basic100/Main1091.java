package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1091 : [기초-종합] 수 나열하기3
 *  
 * @references https://codeup.kr/problem.php?id=1091
 * @author iamdawoonjeong
 */
public class Main1091 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
         
        long result = a;
        for (int i = 1; i < n; i++) {
            result = result*m + d;
        }
        System.out.println(result);

    }

}
