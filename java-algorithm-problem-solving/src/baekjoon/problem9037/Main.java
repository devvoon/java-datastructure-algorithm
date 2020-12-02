package baekjoon.problem9037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *  9037 The candy war
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/9037
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] candy= new int[n];
            
            for (int j = 0; j < n; j++) {
                candy[j] = Integer.parseInt(st.nextToken());
            }
            solution(n, candy);
        }
        
    }

    public static void solution(int n, int[] candy) {

        int count = 0;
        
        //배열내 수가 같아질때까지 while문 반복 
        while (!check(n, candy)){
            circulation(n, candy);
            count++;
        }
        System.out.println(count);
    }

    /**
     * 사탕 갯수 체크
     * @param candy
     * @return
     */
    
    public static boolean check(int n, int[] candy) {
    
        //중복허용하지 않는 set에 담아서 길이체크 
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (candy[i]%2 == 1) {
                candy[i]++;
            }
            set.add(candy[i]);
        }
        
        //길이가 1이면 모두 같은 수임
        return set.size() == 1 ? true : false;
    }
    
    /**
     * 순환
     * @param n
     * @param candy
     */
    public static void circulation(int n, int[] candy) {
        
        // 오른쪽사람에게 더 해질 사탕 갯수 따로 관리
        int[]  arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            //홀수개 인 경우 
            if (candy[i]%2 == 1) {
                // 한개추가
                candy[i]++;
            }
            
            //자신의 갯수의 반을 
            candy[i] /=2;
            // 오른쪽사람에게 줌
            arr[(i+1)%n] = candy[i];
        }
        
        //반개를 주고 남은 갯수와 더 해질 갯수 더함
        for (int i = 0; i < n; i++) {
            candy[i] += arr[i];
        }
    }

}
