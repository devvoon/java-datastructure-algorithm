package baekjoon.problem12849;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 12849 본대 산책
 * 
 * @references https://www.acmicpc.net/problem/12849
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //0: 정보과학관
        //1: 전산관
        //2: 미래관
        //3: 신양관
        //4: 한경직기념관
        //5: 진리관
        //6: 학생회관
        //7: 형남공학관

        int[] dp = new int[] {1, 0, 0, 0, 0, 0, 0, 0};
        
        //n분의 시간만큼 걸렸을때
        for (int i = 0; i < n; i++) {
            dp = next(dp); //1분후 위치에 따른 점화식
        }
        
        //1000000007 소수 : 나누고 나머지이면 해시값이 출력됨
        System.out.println(dp[0]);

    }
    
    public static int[] next(int[] state) {
        int[] temp = new int[8];
        temp[0] = state[1] + state[2];
        temp[1] = state[0] + state[2] + state[3];
        temp[2] = state[0] + state[1] + state[3] + state[4];
        temp[3] = state[1] + state[2] + state[4] + state[5];
        temp[4] = state[2] + state[3] + state[5] + state[7];
        temp[5] = state[3] + state[4] + state[6];
        temp[6] = state[5] + state[7];
        temp[7] = state[4] + state[6];
        
        for (int i = 0; i < 8; i++) {
            temp[i] = temp[i]%1000000007;
        }
        
        return temp;
    }

}
