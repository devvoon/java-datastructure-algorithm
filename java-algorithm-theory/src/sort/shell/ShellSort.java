package sort.shell;

public class ShellSort {
    
    public int elementData[];
    
    public ShellSort(int arrInput[]) {
        // 1차원 배열 deep copy= value assignment(값에 의한 대입)
        // 값이 복사함으로 main에서 배열 값이 변경되어도 영향을 받지 않음 
        elementData = arrInput.clone();
        
        //1차원 배열 shallow copy = reference assignment(참조에 의한 대입)
        // main에서 배열 값이 변경 될 경우, 같은 레퍼런스를 참조하고 있기 때문에 영향을 받아 함께 변경 됨
        // elementData = arrInput ; 
    }
    
    public void sort() {
        int size = elementData.length;
        
        //gap(h) 정하기 처음엔 배열길이/2 로 시작하여 계속해서 2로 나눔 
        for (int gap = size/2 ; gap > 0 ; gap /=2) {
             for (int i = gap ; i < size ; i++) {
                // gap 위치인 i의 값을 temp에 저장해두기 ([i]값은 비워짐) 
                int temp = elementData[i]; 
                
                int j;
                //temp에 넣어 둔 값과 gap반큼 뺀 인덱스위치의 값과 비교하여 temp값이 클 경우  
                for (j = i;  j >= gap && elementData[j-gap]>temp; j = j-gap) {
                    //swap
                    elementData[j] = elementData[j-gap];
                } 
                //temp에 넣어둔 값 넣어주기 
                elementData[j] = temp;
             }
        }
    }
    
    public String toString() {
        String str = "[";
        
        for (int i = 0; i < elementData.length; i++) {
             str = str +  elementData[i];
             if (i < elementData.length-1) {
                 str = str + ", "; 
             }
        }
        return str + "]";
    }

}
