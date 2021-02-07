package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1085 : [기초-종합] 소리 파일 저장용량 계산하기(설명)   
 *  
 * @references https://codeup.kr/problem.php?id=1085
 * @author iamdawoonjeong
 */
public class Main1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double  h = Integer.parseInt(st.nextToken());  // h는 48,000이하 1초 동안 마이크로 소리강약을 체크하는 수를 h
        double  b = Integer.parseInt(st.nextToken());  // b는 32이하(단, 8의배수) 체크한 결과를 저장하는 비트 b
        double c = Integer.parseInt(st.nextToken());  // c는 5이하  트랙 개수인 채널 c
        double s = Integer.parseInt(st.nextToken());  // s는 6,000이하   녹음할 시간 s

        // 8bit=1Byte
         //1024Byte = 1KB
        //1024KB = 1MB
        double result = (((h*b*c*s)/8)/1024)/1024;
    
        System.out.println(String.format("%.1f", result) + " MB");
    }

}
