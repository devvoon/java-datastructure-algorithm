package baekjoon.problem1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 1920 수 찾기
 * 
 * @references https://www.acmicpc.net/problem/1920
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");

            //set: 순서 없고 중복 안됨
            Set<Integer> set= new HashSet<Integer>();

            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(temp[i]));
            }
            
            int M = Integer.parseInt(br.readLine());
            String[] arr= br.readLine().split(" ");
            
            int[] result = new int[M];
            
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(arr[i]))) {
                    result[i] = 1;
                }else {
                    result[i] = 0;
                }
            }
            
            for (int j = 0; j < M; j++) {
                System.out.println(result[j]);
            }
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
