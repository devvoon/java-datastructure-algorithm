package baekjoon.problem17389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  17389 보너스 점수
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/17389
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] S  = br.readLine().toCharArray();
        int score = 0;
        int bonus = 0;
        
        for (int i = 0; i < N; i++) {
            if (S[i] == 79) {
                score += (i+1) + bonus;
                bonus++;
            }else if (S[i] == 88) {
                bonus = 0;
            }
        }
        
    }
}
