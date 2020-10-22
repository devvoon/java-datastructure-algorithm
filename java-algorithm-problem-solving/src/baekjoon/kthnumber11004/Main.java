package baekjoon.kthnumber11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        br.close();
        isr.close();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
             arr[i] = (Integer.parseInt(st.nextToken())); 
        }
        
        int[] result = sort(arr, 0, arr.length-1);
        System.out.println(result[k-1]);
    }

    private static int[] sort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        
        int pivot = arr[(left+right)/2];
        
        while(left <= right) {
            while( arr[left] < pivot) {
                left++;
            }
            
            while (arr[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                
                left++;
                right--;
            }
        }
        
        if(start < right) {
            sort (arr, start, right);
        }
        
        if (left < end) {
            sort(arr, left, end);
        }
        
        return arr;
    }

}
