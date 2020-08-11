package sort.insert;


public class InsertSortMain {

    public static void main(String[] args) {

        System.out.println("[ * Insert Sort * ]");
        
        //배열임의로 생성 
        int[] numbers = new int[]{9,5,6,4,7,2,1,8,3};
        
        //BubbleSort 인스턴스화 
        InsertSort insert = new InsertSort(numbers);
        
        // 정렬 전 배열 출력 
        System.out.println("- before insert sort ----------");
        System.out.println(insert.toString());
        
        // 정렬 
        insert.sort();
        
        // 정렬 후 배열 출력 결과 확인
        System.out.println("- after insert sort -----------");
        System.out.println(insert.toString());

    }

}
