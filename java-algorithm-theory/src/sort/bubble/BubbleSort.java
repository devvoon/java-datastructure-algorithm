package sort.bubble;

public class BubbleSort {

    public int elementData[];

    public BubbleSort(int arrInput[]) {
        // 1차원 배열 deep copy= value assignment(값에 의한 대입)
        // 값이 복사함으로 main에서 배열 값이 변경되어도 영향을 받지 않음 
        elementData = arrInput.clone();
        
        //1차원 배열 shallow copy = reference assignment(참조에 의한 대입)
        // main에서 배열 값이 변경 될 경우, 같은 레퍼런스를 참조하고 있기 때문에 영향을 받아 함께 변경 됨
        // elementData = arrInput ; 
    }
    
    /**
     * sort
     */
    public void sort() {
        int size  = elementData.length;
        
        //swap 했는지 체크
        boolean swaped ;
        for (int i = 0; i < size-1; i++) {
            
            swaped = false;
            for (int j = 0; j < size-i-1 ; j++) {

                //인덱스값이 1만큼 큰 값과 비교하여 작은 값을 만났을 경우
                if(elementData[j] > elementData[j+1]) {
                    //swap  
                    int temp = elementData[j];
                    elementData[j] = elementData[j+1];
                    elementData[j+1] = temp;
                    swaped = true;
                }
            }
            
            //swap이 한번도 되지 않았다면 정렬되었음으로 break
            if (swaped==false) {
                break;
            }
            System.out.println(toString());
        }
    }
    
    /**
     * print the array
     */
    public String toString() {
        String str = "[" ;
        
        for (int i = 0; i < elementData.length; i++) {
             str = str + elementData[i] ;
             
             if ( i < elementData.length-1) {
                str = str + ", " ;
             }
        }
        return str + "]";
    }

}
