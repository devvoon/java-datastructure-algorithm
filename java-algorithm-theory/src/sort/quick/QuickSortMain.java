package sort.quick;

/**
 * Quick Sort 구현
 * @author iamdawoonjeong
 *
 */
public class QuickSortMain {

    public static void main(String[] args) {
        System.out.println("[ * Quick Sort * ]");
        
        //배열임의로 생성 
        int[] arr = new int[]{9,5,6,4,7,2,1,8,3};
        int size = arr.length-1;

        // 정렬 전 배열 출력 
        System.out.println("- before quick sort ----------");
        System.out.println(toString(arr));
        
        // 정렬 
        System.out.println("- sorting ----------");

        sort(arr, 0, size);
    }
    
    /**
     * quick sort 구현 
     * pivot보다 큰 elements는 pivot의 오른쪽으로
     * pivot보다 작은 elements는 pivot의 왼쪽으로
     * 마지막 pivot까지 진행
     * @param arr : Array to be sorted
     * @param start : Starting index
     * @param end  Ending index 
     */
    public static void sort(int[] arr, int start, int end) {
        //int pivot = arr[end];
        int left = start;
        int right = end ;
        System.out.println(toString(arr));
        // pivot값을 가운데 값으로 셋팅
        int pivot = arr[(left+right)/2];
        while( left <= right) {
         
            // pivot 왼쪽의 값이  pivot 값 보다 작은 경우 다음 element 탐색 
            while(arr[left] < pivot) {
                left++;
            }
            
            // pivot 오른쪽의 값이 pivot값 보다 큰 경우 다음 element 탐색  
            while(arr[right] > pivot) {
                right--;
            }

            // 왼쪽 값 > pivot 이고
            // 오른쪽 값 < pivot 이면서
            // 왼쪽값 < 오른쪽 값 인 경우
            if( left <= right) {
                //swap 
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                
                //그리고 다음 element 탐색 
                left++;
                right--;
            }
        }
        
        if (start < right ) {
            // 분할된 왼쪽 부분 순환 처리
            sort(arr, start, right);
        }

        if (left < end ) {
            // 분할된 오른쪽 부분 순환 처리
            sort(arr, left, end);
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
