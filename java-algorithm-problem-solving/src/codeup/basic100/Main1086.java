package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1086 : [기초-종합] 그림 파일 저장용량 계산하기(설명)
 *   
 * @references https://codeup.kr/problem.php?id=1086
 * @author iamdawoonjeong
 */
public class Main1086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double w = Integer.parseInt(st.nextToken());  //이미지의 가로 해상도 w, h는 모두 정수이고 1~1024 
        double h = Integer.parseInt(st.nextToken());  //세로 해상도 h, 
        double b = Integer.parseInt(st.nextToken()); //한 픽셀을 저장하기 위한 비트 b는 40이하의 4의 배수
        
        double result = (w*h*b)/8/1024/1024;
        //소수점 이하 셋째 자리에서 반올림해 둘째 자리까지 출력한 뒤 MB를 출력
        System.out.println(String.format("%.2f", result) + " MB");
        

    }

}
