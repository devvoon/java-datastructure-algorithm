package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1046 : [기초-산술연산] 정수 3개 입력받아 합과 평균 출력하기
 *  
 * @references https://codeup.kr/problem.php?id=1046
 * @author iamdawoonjeong
 */
public class Main1046 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long sum = a+b+c;
        float por = ((float)sum/(float)3);
        
        System.out.println(sum);
        System.out.println(String.format("%.1f", por));
    }

}
