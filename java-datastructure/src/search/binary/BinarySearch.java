package search.binary;

/**
 * 이진검색 구현
 * @author iamdawoonjeong
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("[ * Binary Search * ]");
        
        //이진 검색 배열은 오름차순으로 정렬되어 있어야 함 
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        
        //검색할 값 x 
        int x = 8;
        
        System.out.println("- elements ----------");
        System.out.println(toString(arr));
        System.out.println("search  : " + x );
        
        // 검색 
        int result = binarySearch(arr, x);
        
        if (result == -1) {
            System.out.println("Element is not present ");
        }else {
            System.out.print("Element is present at index " + result);
        }
        
        
        System.out.println();
        System.out.println("- Binary Search using Recursion ----------");
        
        int resultRecursion = binarySearchRecursion(arr, x, 0, arr.length-1);
        
        if (resultRecursion == -1) {
            System.out.println("Element is not present ");
        }else {
            System.out.print("Element is present at index " + result);
        }
     }

    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length -1;
        
        //왼쪽위치가 오른쪽 위치보다 커질때까지 반복
        while (left <= right) {
            //중간요소 위치 계산
            int mid = left + (right-left)/2; 
            
            // 중간 요소와 일치하면 중간 인덱스를 반환
            if(arr[mid] == x) {
                return mid;
            }
            
            // x가 중간 요소보다 클 경우 
            if(arr[mid] < x) {
                // 중간 요소 다음의 오른쪽 절반 하위 배열에만 놓고, 오른쪽 절반을 반복
                // 왼쪽 위치 재조정 
                left = mid + 1;
            
            // x가 중간 요소 보다 작은 경우
            }else {
                // 왼쪽 절반 하위 배열만 놓고, 왼쪽 절반에 반복
                // 오른쪽 위치 재조정
                right = mid - 1;
            }
        }
        //찾을수 없을 경우 -1 반환
        return -1;
    }

    /**
     * recursion을 이용한 binarySearchRecursion
     * @param items
     * @param target
     * @param begin
     * @param end
     * @return
     */
    public static int binarySearchRecursion(int[] items, int target, int begin, int end){
        if(begin > end){
            return -1;
        }else {
            int middle = (begin+end)/2;
            int compResult = Integer.toString(target).compareTo(Integer.toString(items[middle]));
            
            if (compResult == 0){
                return middle;
            } else if (compResult<0){
                return binarySearchRecursion(items, target, begin, middle-1);
            } else {
                return binarySearchRecursion(items, target, middle+1, end);
            }
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
