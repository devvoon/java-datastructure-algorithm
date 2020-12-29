package baekjoon.problem14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *  14620 꽃 길
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/14620
 *
 */
public class Main {

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static int[][] arr;
    static int n ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st ;
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <  n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } 
    
        int result = 4000;  //임의의 큰수 지정
        //3개 위치 추출 
        for (int i = 0; i < n*n; i++) {
            for (int j = i+1; j < n*n; j++) {
                for (int k = j+1; k < n*n; k++) {
                    
                    ArrayList<Integer>  list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    list.add(k);
                    //(0 1 2) ~  (33 34 35) 각 수 체크
                    result = Math.min(result, check(list));
                }
            }
        }
        
        System.out.println(result);
    }

    public static int check(ArrayList<Integer> list) {
        int result = 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (Integer it : list) {
            int i = it/n;
            int j = it%n;
            
            //꽃씨 심는자리 
            result += arr[i][j];
            set.add(it);
            
            //꽃씨 주변 꽃 피는 자리 (상, 하, 좌, 우)
            for (int k = 0; k < 4; k++) {
                int nextX = i + dx[k];
                int nextY = j + dy[k];
                
                if ( nextX < 0 || nextX >= n || nextY < 0 || nextY >= n  ) {
                    return 4000;
                }
                result += arr[nextX][nextY];
                set.add(nextX * n + nextY );
            }
        }
        
        //겹치는 칸이 있는경우 15개가 아니게 됨으로 4000리턴
        if (set.size() != 15) {
            return 4000;
        }
        return result;
    }

}
