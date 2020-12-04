package baekjoon.problem16675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 16675 두 개의 손
 * 
 * @references https://www.acmicpc.net/problem/16675
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input =  br.readLine();
        input = input.replace("S", "0"); //S 가위 
        input = input.replace("P", "1"); //P 보 
        input = input.replace("R", "2"); //R 바위
        
        StringTokenizer st = new StringTokenizer(input);
        //민성 
        int ml = Integer.parseInt(st.nextToken());
        int mr = Integer.parseInt(st.nextToken());
        
        //태경
        int tl = Integer.parseInt(st.nextToken());
        int tr = Integer.parseInt(st.nextToken());
        
        //모듈러연산 이용
        if (ml == mr && ((ml+2)%3 == tl || (ml+2)%3 == tr)) {
            //민성이가 같은걸 동시에 낸 상태에서 태성이가 이기는 경우
            System.out.println("TK");
       
        }else if (tl == tr && ( (tl+2)%3 == ml || (tl+2)%3 == mr)) {
            //태성이가 같은걸 동시에 낸 상태에서민성이가 이기는 경우
            System.out.println("MS");
            
        }else {
            System.out.println("?");
        }
    
    }

}
