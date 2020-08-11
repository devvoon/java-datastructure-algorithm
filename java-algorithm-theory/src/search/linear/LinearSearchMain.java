package search.linear;

/**
 * 순차검색 구현 
 * @author iamdawoonjeong
 *
 */
public class LinearSearchMain {

    public static void main(String[] args) {
        System.out.println("[ * Linear Search * ]");
        
        //배열임의로 생성 
        int[] arr = new int[]{9,5,6,4,7,2,1,8,3};
        
        //검색할 값 x 
        int x = 8;
        
        System.out.println("- elements ----------");
        System.out.println(toString(arr));
        System.out.println("search  : " + x );
        
        // 검색 
        int result = linearSearch(arr, x);
        
        if (result == -1) {
            System.out.println("Element is not present in array");
        }else {
            System.out.print("Element is present at index " + result);
        }
    }
    
    public static int linearSearch(int arr[], int x) {
        int n = arr.length;
        
       //순차적으로 arr[]각 요소와 x를 하나씩 비교 
        for (int i = 0; i < n; i++) {
            if(arr[i]==x) {
                // 일치할경우 인덱스 반환 
                return i;
            }
        }
      //일치하지 않을 경우 -1 반환
        return -1;
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
