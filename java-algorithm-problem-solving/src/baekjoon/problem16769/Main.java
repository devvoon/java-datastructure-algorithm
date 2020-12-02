package baekjoon.problem16769;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  16769 The candy war
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/16769
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = 3;
        int[] cup = new int[n];
        int[] milk = new int[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cup[i] = Integer.parseInt(st.nextToken());
            milk[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0 ;
        int next = 0 ;
        
        for (int i = 0; i < 100; i++) {
            
            index = i%3 ;
            next = (i+1)%3;
            
            // 현재 우유양 = 다음컵에 다부어주는 경우와
            // 다음컵용량 남은것 만큼 부어주는 경우 (다음컵용량-다음컵우유양 =다음컵 담을수 있는양)
            int temp = ( cup[next] - milk[next] >= milk[index] ? 0 : milk[index] - (cup[next] - milk[next]));
            //int temp  = Math.max(0,  milk[index] - (cup[next]-milk[next]));
            
            // 다음우유양 = 현재우유+다음우유 
            // 현재우유+다음우유양이 다음컵용량보다 큰 경우에는 컵 용량까지만 가능  
            milk[next] = ( cup[next] > milk[index] + milk[next] ? milk[index] + milk[next]: cup[next]);
            //milk[next] = Math.min(cup[next],  milk[next]+ milk[index]);
            
            // 다음 컵연산에서 현재우유를 사용하기에 temp에 담아주었다가 대입
            milk[index] = temp;
            
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(milk[i]);
        }

    }
}
