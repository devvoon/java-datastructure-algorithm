package sort.bubble;


public class BubbleSortMain {

    public static void main(String[] args) {

        System.out.println("[ * Bubble Sort * ]");
        
        //배열임의로 생성 
        int[] numbers = new int[]{9,5,6,4,7,2,1,8,3};
        
        //BubbleSort 인스턴스화 
        BubbleSort bubble = new BubbleSort(numbers);
        
        // 정렬 전 배열 출력 
        System.out.println("- before bubble sort ----------");
        System.out.println(bubble.toString());
        
        // 정렬 
        bubble.sort();
        
        // 정렬 후 배열 출력 결과 확인
        System.out.println("- after bubble sort -----------");
        System.out.println(bubble.toString());
    }
}
