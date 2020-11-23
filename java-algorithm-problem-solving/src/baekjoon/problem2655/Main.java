package baekjoon.problem2655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 2655 가장높은탑쌓기
 * 
 * @references https://www.acmicpc.net/problem/2655
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int[][] arr = new int[n+1][4];
        
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());  // width 너비
            arr[i][2] = Integer.parseInt(st.nextToken());  // height 높이
            arr[i][3] = Integer.parseInt(st.nextToken());  // weight 무게 
        }
        
        // 문제조건 5에 의하여 무게순으로 탑을 쌓기 위해 weight 오름차순정렬 
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[3], o2[3]);
            }
        });

        // 각 벽돌순서별 최대 높이를 담아줄 배열 선언
        int[] dp = new int[n+1];
        
        //현재 벽돌을 기준으로 i  이전 벽돌들을 j를 확인 
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                
                // 문제 조건4 에 의하여 너비가 좁은 벽돌이 넓은 너비 벽돌 밑으로 갈 수 없음
                //현재 벽돌보다 면적이 적은 벽돌까지만 쌓고, 현재 벽돌의 높이를 더하여 dp에 담음 
                if(arr[i][1] > arr[j][1]) {
                    // 기존까지 쌓았던 높이 중 면적이 현재 벽돌보다 적은 벽돌과 (dp[j]) + 현재높이(arr[i][2])를 더해서 입력해 줌
                    dp[i] = Math.max(dp[i], dp[j]+arr[i][2]);
                }
            }
        }
        
        // 쌓은 벽돌들의 최대 높이를 계산
        int maxValue = 0;
        for (int i : dp) {
            maxValue = Math.max(i, maxValue);
        }
        
        int index = n;
        ArrayList<Integer> result = new ArrayList<Integer>();
                
        while (index != 0) {
            // 최고 높이와 dp에 넣어둔 최대 값이 같은 경우 
            if (maxValue == dp[index]) {
                // 해당 벽돌변호를 result 에 담아주고 
                result.add(arr[index][0]);
                //해당 벽돌의 키를 빼서 다음 벽돌의 높이를 계산할 수 있게 함 
                maxValue -= arr[index][2];
            }
            index--;
        }
        
        // 쌓은 벽돌의 갯수
        System.out.println(result.size());
        
        // 벽돌의 번호를 가장 위 벽돌부터 가장 아래 벽돌까지 차례로 한 줄에 하나씩 출력
        for (int i = result.size()-1 ; i >= 0; i--) {
            System.out.println(result.get(i));
        }

    }

}
