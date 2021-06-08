package programmers.stackqueue;

/**
 * 42584 주식가격
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42584
 * @author iamdawoonjeong
 */
public class Lessons42584 {
    public static void main(String[] args) {
        
        int[] prices = new int[] {1, 2, 3, 2, 3};
        int[] answer = solution(prices);
        
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
    
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int time = 0;
            
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    time++;
                    break;
                }else {
                    time++;
                }
            }
            
            answer[i] = time;
        }

        return answer;
    }

}
