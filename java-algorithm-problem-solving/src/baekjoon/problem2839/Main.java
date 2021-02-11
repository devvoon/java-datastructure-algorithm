package baekjoon.problem2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2839 설탕 배달
 * 
 * @references https://www.acmicpc.net/problem/2839
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //옮겨야할 설탕의 무게 입력받음 
        int max = n/5; // 5키로 최대 갯수 
        int count = 0 ; 
        int remain = n;
            
        while( max >= 0 ) {
            count = 0;   //변수초기화
            remain = n; 
            
            if (max > 0 ) {
                count = max ;
                remain = remain  - (max*5);
            }
            
            if (remain%3 ==0) {
                count = count + (remain/3);
                remain = (remain%3);
            }
            
            if (remain==0) {
               //남은 무게가 없으면 끝내기
                break; 
            }else {
                //5kg의 갯수를 줄여서 다시 연산
                // max = -1 이 되면 종료 
                max--;
            }
        }
        
        if (remain != 0 ) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }

    }

}
