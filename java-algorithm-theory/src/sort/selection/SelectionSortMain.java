package sort.selection;
/**
 * selection sort 구현해보기 
 * @author iamdawoonjeong
 *
 */
public class SelectionSortMain {

    public static void main(String[] args) {

        System.out.println("[ * Selection Sort * ]");
        
        //배열임의로 생성 
        int[] numbers = new int[]{9,5,6,4,7,2,1,8,3};
        
        //SelectionSort 인스턴스화 
        SelectionSort selection = new SelectionSort(numbers);
        
        // 정렬 전 배열 출력 
        System.out.println("- before selection sort ----------");
        System.out.println(selection.toString());
        
        // 정렬 
        System.out.println("- sorting ----------");
        selection.sort();
    }

}
