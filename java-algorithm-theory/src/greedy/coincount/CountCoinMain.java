package greedy.coincount;

/**
 * greedy algorithm - count coin
 * @author iamdawoonjeong
 *
 */
public class CountCoinMain {

    public static void main(String[] args) {

        int[] coins =  {10,100,50,500};
        System.out.println("-----  coin type : ");
        System.out.println(toString(coins));
        
        System.out.println("-----  after coin sort : ");
        int[] sortedCoins = sort(coins);
        System.out.println(toString(sortedCoins));
        
        System.out.println( "----- amount : 4830");
        int[][] result = countCoin(4830, sortedCoins);
        System.out.println(toString(result));
        
        System.out.println( "-----  amount : 11670");
        int[][] result2 = countCoin(11670, sortedCoins);
        System.out.println(toString(result2));
        
    }
    
    /**
     * 동전의 갯수 세기
     * @param amount
     * @param arr
     */
    public static int[][] countCoin(int amount, int[] arr) {
    
        int[] cointCount = new int[arr.length];
        int[][] result = new int[arr.length][2];

        int total = amount;
        
        for (int i = 0; i < arr.length ; i++) {
            if (total >= 0){
                //coin의 갯수가 들어감 
                cointCount[i] = total/arr[i];
                
                //coinCount가 1개 이상일 경우
                if (cointCount[i] >= 1) {
                    //남은 잔액을 계산후 반복 
                    total=total%arr[i];
                    //현재 카운트 된 동전의 금액 : 갯수 
                    result[i][0] =  arr[i];
                    result[i][1] =  cointCount[i];
                    //System.out.println( arr[i] +  " : " +cointCount[i]);
                    //System.out.println(result[i][0]  + " : " +   result[i][1]);
                } //end if
            }
        }
        return result;
    }
    
    /**
     * sort 
     * bubble 정렬을 이용하여 쉬운 로직으로 bubble 정렬을 이용하여 내림차순으로 정렬
     * @param input
     * @return
     */
    public static int[] sort(int[] input) {
        
        int[] arr = input;
        int size = input.length;
        
        boolean swaped;
                    
        for(int i = 0; i < size-1 ; i++) {
            swaped = false;
            
            for (int j = 0; j < size-1-i; j++) {
                if(arr[j] < arr [j+1] ) {
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                   swaped=true;
                }
            }
            
            if (swaped == false) {
                break;
            }
            
        }
        return  arr;
    }
    
    
    /**
     * print array
     * @param arr
     * @return
     */
    public static String toString(int[] arr) {
        String str = "[";
        
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if ( i < arr.length-1) {
               str +=  ", ";
            }
        }
        
        return str + "]";
    }
    
    
    /**
     * print array[][]
     * @param arr
     * @return
     */
    public static String toString(int[][] arr) {
        String str = "[";
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               str += arr[i][j];
               
               if ( j <arr[i].length-1) {
                  str +=  " : ";
               }
            }
            if ( i <arr.length-1) {
                str +=  ", ";
            }
        }
        return str + "]";
   }

}
