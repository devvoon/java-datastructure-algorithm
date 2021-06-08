package programmers.dfsbfs;

/**
 * 43165 타겟 넘버
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/43165
 * @author iamdawoonjeong
 */
public class Lessons43165 {
    
    public static void main(String[] args) {
        
        int[] numbers = new int[] {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println(result);
    }
    
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0 );
        return answer;
    }

    private static int dfs(int[] numbers, int target, int node, int sum) {
    
        if(node == numbers.length) {
            if(sum == target) {
                return 1;
            }else {
                return 0;
            }
        }
        
        return dfs(numbers, target, node+1, sum+numbers[node])
             + dfs(numbers, target, node+1, sum-numbers[node]);
    }

}
