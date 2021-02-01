package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1025 : [기초-입출력] 정수 1개 입력받아 나누어 출력하기(설명)
 * 
 * @references https://codeup.kr/problem.php?id=1025
 * @author iamdawoonjeong
 */
public class Main1025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        
        System.out.println("["+String.format("%d", Integer.parseInt(input[0])*10000)+"]"); //오른쪽0채우기 
        System.out.println("["+String.format("%d", Integer.parseInt(input[1])*1000)+"]"); //오른쪽0채우기
        System.out.println("["+String.format("%d", Integer.parseInt(input[2])*100)+"]"); //오른쪽0채우기
        System.out.println("["+String.format("%d", Integer.parseInt(input[3])*10)+"]"); //오른쪽0채우기
        System.out.println("["+String.format("%d", Integer.parseInt(input[4])*1)+"]"); //오른쪽0채우기

    }

}
