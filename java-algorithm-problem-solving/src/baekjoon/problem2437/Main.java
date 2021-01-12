package baekjoon.problem2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2437 저울
 * 
 * @references https://www.acmicpc.net/problem/2437
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int result = 0; //구할 수 없는 최소 정수값
        
        for (int i = 0; i < n; i++) {
            
            //result+1 반드시 1 필요함
            //추의무게가 <= 구할 무게보다 같거나 작아야 구할수있음  
            if (arr[i] <= result+1) {
                System.out.println(arr[i] + "<= " + (result+1));
                
                result += arr[i];
                System.out.println(result);
            }else {
                break;
            }
        }
        
        System.out.println(result+1);
    }

}
