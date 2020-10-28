package baekjoon.problem2798;

/**
 * 2920  블랙잭
 * 
 * @reference https://www.acmicpc.net/problem/2798
 * @author iamdawoonjeong
 */
import java.util.Scanner;

public class Main {
    public static void main(String asgs[]) {
        
        Scanner sc = new Scanner(System.in);
        String sc1 = sc.nextLine();
        String sc2 = sc.nextLine();
        sc.close();
        
        //첫번째 라인
        String[] str = sc1.split(" ");
        int N = Integer.parseInt(str[0]); //카드의 갯수
        int M = Integer.parseInt(str[1]); //카드 3개의 합
        
        //두번째 라인
        String[] str2 = sc2.split(" ");
        int numbers[] = new int[N];  // 카드의 숫자들
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(str2[i]);
        }
        
        int sum  = 0;
        int maxSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    //카드의 숫자가 중복 되지 않고
                    if ((numbers[i] != numbers[j]) && (numbers[j] != numbers[k]) && (numbers[i] != numbers[k])) {
                        sum  = numbers[i] + numbers[j] + numbers[k] ;
                        //세 카드 숫자의 합이 M보다 작아야 하며
                        if (sum <= M ) {
                            //최대 합을 찾기
                            if(sum >= maxSum) {
                                maxSum = sum;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(maxSum);
    }

}
