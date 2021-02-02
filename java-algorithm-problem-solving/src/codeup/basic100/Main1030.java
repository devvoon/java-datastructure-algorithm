package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1030 : [기초-데이터형] 정수 1개 입력받아 그대로 출력하기3(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1030
 * @author iamdawoonjeong
 */
public class Main1030 {

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //-9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807
        long l = Long.parseLong(br.readLine());  //-2147483649
        //System.out.println(d); // -2.147483649E9
        System.out.println(l); // -2.147483649E9
    }

}
