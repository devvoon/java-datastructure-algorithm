package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1026 : [기초-입출력] 시분초 입력받아 분만 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1026
 * @author iamdawoonjeong
 */
public class Main1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\:");
        System.out.println(String.format("%d", Integer.parseInt(input[1])));  // 00 -> 0  으로 출력
    }

}
