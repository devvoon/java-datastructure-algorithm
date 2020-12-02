package baekjoon.problem17224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  17224 APC는 왜 서브태스크 대회가 되었을까?
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/17224
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); //문제의 개수 N,
        int L = Integer.parseInt(st.nextToken()); //역량 L
        int K = Integer.parseInt(st.nextToken()); //문제의 최대 개수 K
        
        //쉬운 버전의 난이도 sub1, 어려운 버전의 난이도 sub2 가 순서대로 주어짐
        int[] sub1 = new int[N];
        int[] sub2 = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sub1[i] = Integer.parseInt(st.nextToken());
            sub2[i] = Integer.parseInt(st.nextToken()); 
        }
        
        int score = 0;
        
        int easy = 0;
        int hard = 0;
        
        //풀수있는 문제의 갯수 구하기
        for (int i = 0; i < N; i++) {
            
            //어려운 버전의 난이도 sub2를 풀었을때는 140점 획득
            if (L >= sub2[i]) {
                hard++;
            }else if (L < sub2[i] && L >= sub1[i] ){
                //어려운 버전은 못풀고 쉬운버전 sub1 풀었을때에는 100점 획득
                easy++;
            }
        }
        
        //어려운 문제 점수계산 
        int solved = Math.min(K, hard);
        score = solved*140;
        
        //풀수있는 문제의 갯수가 남아있다면 쉬운문제 점수 계산
        if ( hard < K) {
            solved = Math.min(K-hard, easy) ;
            score += solved*100;
        }
        
        System.out.println(score);

    }

}
