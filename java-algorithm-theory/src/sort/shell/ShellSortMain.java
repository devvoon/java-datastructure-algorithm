package sort.shell;

/**
 * Shell Sort 구현
 * @author iamdawoonjeong
 *
 */
public class ShellSortMain {
    
    public static void main(String[] args) {

        System.out.println("[ * Shell Sort * ]");
        
        //배열임의로 생성 
        int[] numbers = new int[]{9,5,6,4,7,2,1,8,3};
        
        //ShellSort 인스턴스화 
        ShellSort shell = new ShellSort(numbers);
        
        // 정렬 전 배열 출력 
        System.out.println("- before shell sort ----------");
        System.out.println(shell.toString());
        
        // 정렬 
        System.out.println("- sorting ----------");
        shell.sort();
        
        // 정렬 후 배열 출력 결과 확인
        System.out.println("- after shell sort -----------");
        System.out.println(shell.toString());
    }
    
}
