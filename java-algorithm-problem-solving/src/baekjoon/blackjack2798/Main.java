package baekjoon.blackjack2798;

/**
 * 2920  블랙잭
 * 
 * [문제]
 * 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 
 * 블랙잭은 카지노마다 다양한 규정이 있다.
 * 
 * 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
 * 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 
 * 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
 * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
 * 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 * 
 * [입력]
 * 첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 
 * 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는다.
 * 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
 * 
 * [출력]
 * 첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 * 
 * [예제]
 * 5 21 
 * 5 6 7 8 9
 * -> 21
 * 
 * 10 500
 * 93 181 245 214 315 36 185 138 216 295 
 * -> 497
 * 
 * @reference https://www.acmicpc.net/problem/2798
 * @author iamdawoonjeong
 *
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
