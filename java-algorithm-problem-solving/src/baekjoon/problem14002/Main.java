package baekjoon.problem14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 14002 가장 긴 증가하는 부분 수열 4
 * 
 * @references https://www.acmicpc.net/problem/14002
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        int[] reverse = new int[n];
        int index = 0;
        
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((arr[j] < arr[i]) && (dp[i] < dp[j]+1) ) {
                    dp[i] = dp[j]+1;
                    //i를 위해 참조한 인덱스 j저장 
                    reverse[i] = j;
                }
            }
            //최대값을 가진 dp의 index 구하기
            if (dp[index] < dp[i]) {
                index = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        //최대값 
        sb.append(dp[index]+"\n");
        
        //최대값을 만든 값들을 담을  list
        //ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack =new Stack<Integer>();
        while(reverse[index] != index) {
           // list.add(arr[index]);
            stack.push(arr[index]);
            index = reverse[index];
        }
        
        // 최초값 담음
        //list.add(arr[index]);
        stack.push(arr[index]);
        
        //list를 역순으로 담았기에 맨뒤에서부터 담기
        /*
        for (int i = list.size()-1 ; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }*/
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        
        
        //출력
        System.out.println(sb.toString());

    }

}
