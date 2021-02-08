package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1095 : [기초-1차원배열] 이상한 출석 번호 부르기3(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1095
 * @author iamdawoonjeong
 */
public class Main1095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }

}
