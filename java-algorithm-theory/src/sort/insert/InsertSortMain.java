package sort.insert;


public class InsertSortMain {

    public static void main(String[] args) {

        System.out.println("[ * Insert Sort * ]");
        
        //배열임의로 생성 
        int[] numbers = new int[]{9,5,6,4,7,2,1,8,3};
        
        //BubbleSort 인스턴스화 
        InsertSort insertFor = new InsertSort(numbers);
        InsertSort insertWhile = new InsertSort(numbers);
        
        // 정렬 전 배열 출력 
        System.out.println("- ** before insert sort using for  ----------");
        System.out.println(insertFor.toString());
        
        // 정렬
        System.out.println("- sorting ----------");
        insertFor.sortFor();
        
        // 정렬 전 배열 출력 
        System.out.println("- ** before insert sort using while ----------");
        System.out.println(insertWhile.toString());
        
        System.out.println("- sorting ----------");
        insertWhile.sortWhile();
    }

}
