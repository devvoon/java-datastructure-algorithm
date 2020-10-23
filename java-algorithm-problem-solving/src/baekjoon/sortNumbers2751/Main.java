package baekjoon.sortNumbers2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 2751 수 정렬하기 2 (병합정렬 merge sort이용)
 * 
 * @references https://www.acmicpc.net/problem/2751
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        sort(arr, 0, arr.length-1);
        
        for (int i : arr) {
            bw.write(i+"\n");
        }
        
        bw.flush();
        bw.close();
        osw.close();

        br.close();
        isr.close();

    }

    /**
     * 정렬
     * @param arr
     * @param left
     * @param right
     */
    private static void sort(int[] arr, int left, int right) {
    
        if (left < right) {
            int mid = (left+right)/2;
            sort (arr, left, mid);
            sort (arr, mid+1, right);
            
            merge(arr, left, mid, right);
        }
    }

    /**
     * 병합
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int sizeLeft = mid-left+1;
        int sizeRight = right-mid;
        
        int[] L = new int[sizeLeft];
        int[] R = new int[sizeRight];
        
        for (int i = 0; i < sizeLeft; i++) {
            L[i] = arr[left+i];
        }
        
        for (int j = 0; j < sizeRight; j++) {
            R[j] = arr[mid+1+j];
        }
        
        int i = 0;
        int j = 0;
        int k = left;
        
        while ( i < sizeLeft && j < sizeRight) {
            if( L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < sizeLeft) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j < sizeRight) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
