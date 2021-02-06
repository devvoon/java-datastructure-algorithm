package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1073 : [기초-반복실행구조] 0 입력될 때까지 무한 출력하기2(설명)
 *  
 * @references https://codeup.kr/problem.php?id=1073
 * @author iamdawoonjeong
 */
public class Main1073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while(true) {
            int n= Integer.parseInt(st.nextToken());
            
            if (n ==0) {
                break;
            }else {
                System.out.println(n);
            }
            
        }

    }

}
