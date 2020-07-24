package sort.insert;

public class InsertSort {
    public int elementData[];
    
    public InsertSort(int arrInput[]) {
        // 1차원 배열 deep copy= value assignment(값에 의한 대입)
        // 값이 복사함으로 main에서 배열 값이 변경되어도 영향을 받지 않음 
        elementData = arrInput.clone();
        
        //1차원 배열 shallow copy = reference assignment(참조에 의한 대입)
        // main에서 배열 값이 변경 될 경우, 같은 레퍼런스를 참조하고 있기 때문에 영향을 받아 함께 변경 됨
        // elementData = arrInput ; 
    }
    
    public void sort(){
        int size = elementData.length;
        
        for (int i = 0; i < size; i++) {
            int key = elementData[i];
            int j = i-1;
            
            //이미 정렬되어있는 i~1 부터 0 까지 의 값 중에서 i번째의 key 보다 큰 값을 만나면 
            while(j >= 0 && elementData[j] > key) {
                //해당 위치에 큰 값을 대입 
                elementData[j+1] = elementData[j];
                //큰 값일 나오지 않을때까지 반복  
                j = j-1;
           }
           //큰 값이 더이상 나오지 않고 while문이 종료되면 
           //key값을 [j+1] 위치에 넣어줌 
            elementData[j+1] = key; 
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
