package sort.merge;

/**
 * MergeSort 구현
 * @author iamdawoonjeong
 *
 */
public class MergeSortMain {

    public static void main(String[] args) {
       System.out.println("[ * Merge Sort * ]");
        
        //배열임의로 생성 
        //int[] arr = new int[]{9,5,6,4,7,2,1,8,3};
        int[] arr = new int[]{38,27,43,3,9,82,10};
        
        // 정렬 전 배열 출력 
        System.out.println("- before merge sort ----------");
        System.out.println(toString(arr));
        
        // 정렬
        System.out.println("- sorting ----------");
        split(arr, 0, arr.length-1);
        
        // 정렬 후 배열 출력 결과 확인
        System.out.println("- after merge sort ----------");
        System.out.println(toString(arr));
    }

    /**
     * 분할 
     * @param arr
     * @param left
     * @param right
     */
    public static void split(int[] arr, int left, int right) {
        if (left < right) {
            //(분할) 중앙요소 위치 찾기 
            int mid = (left + right) /2;
            
            //(분할) 앞 부분 : left (0) ~ mid / 뒷 부분 : mid+1 ~ right (n) 까지  
            split(arr, left, mid);  
            split(arr, mid+1 , right); 
            
            //(병합)
            System.out.print(left + " " + mid + " " + right  + ": ");
            merge(arr, left, mid, right);
            System.out.println("        " + toString(arr));
        }
    }
    
    /**
     * 병합
     * 첫번째 sub array array[left..mid]
     * 두번째 sub array array[mid+1..right]
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {

        //병합될 두 sub arrays 의 사이즈 찾기 
        int n1 = mid - left + 1 ;
        int n2 = right - mid;
        
        // (복사) mid를 기준으로 왼쪽 / 오른쪽 2개 파트로 나눌 임시 배열 생성
        // 또는 arr에 대한 임시 배열을 만들어서 넣어주고, 병합 후 임시배열을 arr 복사해서 넣어주어도 됨
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        // 임시 배열값 복사
        for (int i = 0; i < n1; i++) {
            L[i]  = arr[left + i];

        }
        
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        
        System.out.print(toString(L) + " " + toString(R) + " -->  ");
        
        //merge
        //초기 인덱스
        int i = 0;
        int j = 0;
        
        // 병합된 subarray의 초기 인덱스
        int k = left;
        
        // L 사이즈만 큼 loop (L배열 초기 인덱스 < L배열 사이즈)
        // R 사이즈만 큼 loop (R배열 초기 인덱스 < R배열 사이즈)  
        while (i < n1 && j < n2) {
            // L 배열의 값 <= R배열의 값
            if (L[i] <= R[j]) {
                // L값 arr에 담아주기 
                arr[k] = L[i];
                //L 을 담아주었으니 L의 인덱스 증가 
                i++;
            }else {
                // L 배열의 값 > R배열의 값 
                // R값 arr에 담아주기
                arr[k] = R[j];
                //R 을 담아주었으니 R의 인덱스 증가
                j++;
            }
            k++;
        }
        
        //L에 남은 값이 있다면 복사 
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        //R에 남은 값이 있다면 복사  
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
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
