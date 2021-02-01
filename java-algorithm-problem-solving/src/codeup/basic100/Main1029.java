package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1029 : [기초-데이터형] 실수 1개 입력받아 그대로 출력하기2(설명) 
 * 
 * @references https://codeup.kr/problem.php?id=1029
 * @author iamdawoonjeong
 */
public class Main1029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //(+- 1.7*10-308 ~ +- 1.7*10308 ) : 3.14159265359 
        double d= Double.parseDouble(br.readLine());  //+- 1.7*10-308 ~ +- 1.7*10308 
        //System.out.println(String.format("%.11f", f));  //3.14159274101 (+- 3.4*10-38 ~ +- 3.4*1038 )
        System.out.println(String.format("%.11f", d));  //3.14159265359

    }

}
