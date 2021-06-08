package programmers.search;

/**
 * 42842 카펫
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42842
 * @author iamdawoonjeong
 */
public class Lessons42842 {

    public static void main(String[] args) {

        int brown = 50;
        int yellow = 22;
                
        int[] answer = solution(brown, yellow);
        
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int area = brown + yellow;
        
        //row 가로 >= col 세로 
        
        int col = 0;
        for (int row = 1; row < area; row++) {
            if (area%row==0) {
                col = area/row;
            }else {
                continue;
            }
            
            if (row<col) {
                continue;
            }else {
                int yellowarea = (col-2)*(row-2);
                
                if (yellowarea == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }
        
        return answer;
    }
}
