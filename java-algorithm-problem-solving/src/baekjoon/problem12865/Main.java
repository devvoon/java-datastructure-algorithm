package baekjoon.problem12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 12865 평범한 배낭
 * 
 * @references https://www.acmicpc.net/problem/12865
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //최대무게
        
        int[][] dp = new int[k+1][n+1];
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());  //weight
            value[i] = Integer.parseInt(st.nextToken());  //value
        }
        
        br.close();
        
        //배낭무게 1 ~ k 까지 하나씩 채움
        for (int i = 1; i <= k; i++) {
            //물건 무게 1 ~  n까지 하나씩 채움
            for (int j = 1; j <= n; j++) {
                // 물건무게가 배낭무게보다 적어 담을 수 있는 경우
                if (weight[j] <= i) {
                    // 위에있던 값, 이전에 구했던 값을 비교해서 큰 거 넣기
                    // dp[i-weight[j]][j-1] = [배낭무게 - 물건무게][이전물건무게의 최대가치] + 현 물건의 가치
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-weight[j]][j-1] + value[j]);
                }else {
                    //물거의 무게가 배낭무게보다 커서 담을 수 없는 경우
                    //같은 배낭 무게에서 내려옴
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        System.out.println(dp[k][n]);
    }

}
