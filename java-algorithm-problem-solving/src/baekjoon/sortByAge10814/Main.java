package baekjoon.sortByAge10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 10184 나이순 정렬
 * 
 * @reference https://www.acmicpc.net/problem/10814
 * @author iamdawoonjeong
 *
 */
public class Main {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int n = Integer.parseInt(br.readLine());
            String[][] arr = new String[n][2];
            
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" "); 
                arr[i][0] = str[0]; //나이
                arr[i][1] = str[1]; //이름
            }
            
            Arrays.sort(arr, new Comparator<String[]>() {

                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
                }
            });
            
            for (String[] strings : arr) {
                System.out.println(strings[0] + " "+ strings[1] );
            }
            
            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
