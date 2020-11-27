package baekjoon.problem9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9663 N-Queen
 * 
 * @references https://www.acmicpc.net/problem/9663
 * @author iamdawoonjeong
 */
public class Main {

    public static int n;
    public static int result;
    public static int[] row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        row = new int[n];
        
        //dfs 로 0번째 행부터 확인 
        dfs(0);
        System.out.println(result);

    }

    /**
     * x번째 행에 대하여 처리
     * @param x
     */
    public static void dfs(int x ) {
    
        if ( x == n ) {
            result += 1;
        }else {
            
            // x번째 행의 각 열에  퀸을 두어서 괜찮은지 확인해보기 
            for (int i = 0; i < n ; i++) {
                row[x] = i;
                
                //  해당 위치에 두어도 괜찮은 경우 
                if (check(x)) {
                     // 다음 행으로 넘어가기
                    dfs(x+1);
                }
            }
        
        }
    }

    /**
     * x번째 행에 놓은 Queen 에 대해서 검증
     * @param x
     * @return
     */
    public static boolean check(int x) {
        
        // 이전 행에서 놓았던 모든 Queen 들을 확인 
        for (int i = 0; i < x; i++) {
            // 위쪽 확인 
            if (row[x] == row[i]){
                return false;
            }
            // 대각선 확인 
            if ((Math.abs(row[x] - row[i])) == x - i) {
                return false;
            }
        }
        
        return true;
    }
}
