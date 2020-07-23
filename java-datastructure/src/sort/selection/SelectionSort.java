package sort.selection;
/**
 * selection sort implementation
 * @author iamdawoonjeong
 *
 */
public class SelectionSort {

    public int elementData[];

    public SelectionSort(int arrInput[]) {
        // 1차원 배열 deep copy= value assignment(값에 의한 대입)
        // 값이 복사함으로 main에서 배열 값이 변경되어도 영향을 받지 않음 
        elementData = arrInput.clone();
        
        //1차원 배열 shallow copy = reference assignment(참조에 의한 대입)
        // main에서 배열 값이 변경 될 경우, 같은 레퍼런스를 참조하고 있기 때문에 영향을 받아 함께 변경 됨
        // elementData = arrInput ; 
    }
    
    public void sort(){
        int size = elementData.length;
        
        for (int i = 0; i < size-1; i++) {
            int indexMin = i;
            for (int j = i+1 ; j < size; j++) {
                //배열 내, 최소인덱스에 있는 값보다 작은 값을 만났을 경우
                if (elementData[indexMin] > elementData[j]) {
                    //swap 해주기 
                    int temp = elementData[indexMin];
                    elementData[indexMin] = elementData[j];
                    elementData[j] = temp;
                }
            }
        }
    }
    
    /**
     * print the array
     */
    public String toString() {
        String str = "[";
        for (int i = 0; i < elementData.length; i++) {
            str = str + elementData[i];
            
            if (i < elementData.length-1) {
                str = str + ", ";
            }
        }
        return str+ "]";

    }
}
