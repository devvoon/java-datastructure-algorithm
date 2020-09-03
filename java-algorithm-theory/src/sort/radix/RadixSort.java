package sort.radix;

import java.util.Arrays;

/**
 * Radix Sort 구현
 * @author iamdawoonjeong
 *
 */
public class RadixSort {

    public static void main(String[] args) {
        System.out.println("[ * Radix Sort * ]");
        
        //배열임의로 생성 
        int[] arr = new int[]{10,21,17,34,44,11,654,123}; 
        
        // 정렬 전 배열 출력 
        System.out.println("- before radix sort ----------");
        System.out.println(toString(arr));
        
        // 정렬 
        System.out.println("- sorting ----------");
        radixSort(arr, arr.length);
        
        // 정렬 후 배열 출력 결과 확인
        System.out.println("- after radix sort ----------");
        System.out.println(toString(arr));
    }

    /**
     * radix sort
     * @param arr
     * @param n
     */
    public static void radixSort(int[] arr, int n) {
        int max = getMax(arr, n);
        
        //max값과 exp를 이용해서 각 자리수에 대하여 counting sort
        //exp = 10^i (1의자리 , 10의자리, 100의자리...)
        for (int exp = 1; max/exp > 0 ; exp *= 10) {
            countSort(arr, n , exp);
            System.out.println(toString(arr));
        }
    }

    /**
     * 배열내 최대값 구하기
     * @param arr
     * @param n
     * @return
     */
    public static int getMax(int[] arr, int n) {
        int max = arr[0];
        
        for (int i = 1; i < n; i++) {
             if (arr[i] > max) {
                max = arr[i];
             }
        }
        return max;
    }
    

    /**
     * count sort
     * 각 자리수에 따른 분배
     * @param arr
     * @param n
     * @param exp
     */
    public static void countSort(int[] arr, int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        
        //발생횟수를 count[] 저장 
        for (i = 0; i < n ; i++) {
            count [(arr[i]/exp)%10]++;
        }

        //count [i]에 output[]의 숫자의 실제 위치가 포함되도록 count[i]를 변경
        for (i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }
        
        //출력 배열 저장
        for (i = n-1 ; i >= 0; i--) {
           output[count[(arr[i]/exp)%10]-1]=arr[i];
           count[(arr[i]/exp)%10]--;
        }
        
        // output[]을 arr[]에 복사 
        // arr []에 현재 배열에 따라 정렬 된 숫자가 포함됨
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * print the array
     */
    public static String toString(int arr[]) {
        String str = "[";
        
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
            if(i < arr.length-1) {
                str = str + ",";
            }
         }
        return str + "]";
    }
}
