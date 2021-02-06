package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1072 : [기초-반복실행구조] 정수 입력받아 계속 출력하기(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1072
 * @author iamdawoonjeong
 */
public class Main1072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        int n = Integer.parseInt(input);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            System.out.println(st.nextToken());
        }
    }

}
