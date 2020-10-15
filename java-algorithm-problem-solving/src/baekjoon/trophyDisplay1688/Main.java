package baekjoon.trophyDisplay1688;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            br.close();
            isr.close();

            int left = asending(arr);
            System.out.println(left);
            
            Arrays.sort(arr, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });

            int right = asending(arr);
            System.out.println(right);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int asending(Integer[] arr) {
        
        int count = 1;
        int last = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if ( last < arr[i]) {
                last = arr[i];
                count++;
            }
        }
        
        return count;
    }

}
