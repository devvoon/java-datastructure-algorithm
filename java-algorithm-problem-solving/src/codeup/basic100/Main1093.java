package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1093 : [기초-1차원배열] 이상한 출석 번호 부르기1(설명)  
 *  
 * @references https://codeup.kr/problem.php?id=1093
 * @author iamdawoonjeong
 */
public class Main1093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[24];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
        }

        for (int i = 1; i < 24; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
