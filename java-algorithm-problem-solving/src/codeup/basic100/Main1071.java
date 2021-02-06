package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1071 : [기초-반복실행구조] 0 입력될 때까지 무한 출력하기1(설명)   
 *  
 * @references https://codeup.kr/problem.php?id=1071
 * @author iamdawoonjeong
 */
public class Main1071 {

    static  StringTokenizer st = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        solution( );
    }

    public static void solution() {
        int n = Integer.parseInt(st.nextToken());
        if (n== 0 ){
            return;
        }else {
            System.out.println(n);
            solution();
        }
    }

}
