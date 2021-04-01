package baekjoon.problem1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1543 문서 검색
 * 
 * @references https://www.acmicpc.net/problem/1543
 * @author iamdawoonjeong
 */
public class Main2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String word = br.readLine();
        int length =  word.length();
        int startIndex = 0;
        int endIndex = startIndex + length;
        int count = 0;
        while(true) {
            
            if (startIndex > input.length() || endIndex > input.length()) {
                break;
            }
            
            String sub =  input.substring(startIndex, endIndex);
            
            if (sub.equals(word)){
                startIndex += length;
                count++;
            }else {
                startIndex++;
            }
            endIndex = startIndex + length;

        }
        
        System.out.println(count);
    }
}


