package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1069 : [기초-조건/선택실행구조] 평가 입력받아 다르게 출력하기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1069
 * @author iamdawoonjeong
 */
public class Main1069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        switch (input) {
        case "A": {
            System.out.println("best!!!");
            break;
        }case "B": {
            System.out.println("good!!");
            break;
        }case "C": {
            System.out.println("run!");
            break;
        }case "D": {
            System.out.println("slowly~");
            break;
        }
        default:
            System.out.println("what?");
        }

    }

}
