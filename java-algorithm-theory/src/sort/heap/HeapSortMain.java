package sort.heap;

/**
 * HeapSort 구현
 * @author iamdawoonjeong
 *
 */
public class HeapSortMain {

    public static void main(String[] args) {
        System.out.println("[ * Heap Sort * ]");
        
        //힙은 배열로 구성
        //배열임의로 생성 (insert 하는 것도 만들면 좋음)
        int[] arr = new int[]{9,5,6,4,7,2,1,8,3};
        
        // 정렬 전 배열 출력 
        System.out.println("- before heap sort ----------");
        System.out.println(toString(arr));
        
        // 정렬 
        sort(arr);
        
        // 정렬 후 배열 출력 결과 확인
        System.out.println();
        System.out.println("- after heap sort ----------");
        System.out.println(toString(arr));
    }

    /**
     * heap sort 구현
     * @param arr
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        
        // [build heap] 요소들을 heapify 해주기
        // i = tree의 level이 됨 (i= 3 ~ 0 까지) 
        // 맨아래 level 부터 위로 올라옴 > bottom up 방식
        for (int i = n/2-1; i>=0; i--) {
            heapify(arr, n, i);
        }
        
        System.out.println();
        System.out.println("-  max heapify  ----------");
        System.out.println(toString(arr));
        
        System.out.println();
        System.out.println("- get sorted array  ----------");
        
        // 0. 힙을 빌드 한 후, max 요소는 힙의 루트에 있음 (root의 값은 array[0]으로 제일 큰 값이 됨)
        // 1. max 요소를 (n - 1) 번째 위치로(오름차순을 위해 맨 뒤) 교환 
        // 2. 가장 큰 요소가 적절한 위치에 있고, n 크기를 줄여 힙에서 제거
        // 3. 가장 큰 요소를 교환하면 max heap 속성을 방해 할 수 있으므로 다시 heapify
        // 4. 힙에 요소가 남지 ​​않을 때까지 위의 단계를 수행 하면 결국 정렬 된 배열을 얻게 됨
        for (int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            System.out.println(toString(arr));
        }
    }
    
    /**
     * hepify : heap속성을 충족하기 위해, 힙의 위치를 ​​조정하는 과정
     * 1. max heap 생성하기 위해 현재 요소를 하위 요소와 비교하여 최대 값을 찾은 후
     * 2. 현재 요소가 최대 값이 아닌 경우 최대 값이 위치한 왼쪽 또는 오른쪽 하위 요소로 교환
     * @param arr
     * @param n
     * @param i
     */
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // parent node 
        int left = 2*i + 1; // left node = 2*i + 1
        int right = 2*i + 2; // right node = 2*i + 2
        
        // left의 크기가 array 사이즈 내에 존재 하면서
        // 왼쪽 노드이 값 > 부모노드의 값을 비교 하여 큰 경우
        if(left < n && arr[left] > arr[largest]) {
            //largest index에 left index값을 넣어 줌 (부모노드가 될 것임) 
            largest = left;
        }
        
        // right의 크기가 array 사이즈 내에 존재하면서 
        // 오른쪽 노드의 값이 > 부모 노드의 값과 비교하여 큰 경우
        if (right < n && arr[right] > arr[largest]) {
            //largest index에 right index값을 넣어 줌  (부모노드가 될 것임)
            largest = right;
        }
        
        //자식 노드의 값이 부모노드 보다 큰 값이 존재 할 경우,
        // largest 값이 변경 되었으므로
        if (largest != i) {
            // 부모노드와 <-> 자식노드 swap
            // 임시변수에 기존 parent node 를 저장하고
            int temp = arr[i];
            // 부모 노드를 자식 노드 들 중에 컸던 값으로 대체
            arr[i] = arr[largest];
            // 자식노드에 부모값 저장
            arr[largest] = temp;

            //[순환] 바뀐 largest를 기준으로 다시 heapify
            heapify(arr, n, largest);
        }
    }

    /**
     * 
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
