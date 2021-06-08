package programmers.hash;

import java.util.Arrays;

/**
 * 42577 전화번호 목록
 * 
 * @reference https://programmers.co.kr/learn/courses/30/lessons/42577
 * @author iamdawoonjeong
 */
public class Lessons42577 {
    public static void main(String[] args) {
        
        String[] phone_book = new String[] {"119", "97674223", "1195524421"};
        boolean answer = solution(phone_book);
        
        System.out.print(answer);

    }
    
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
            
        }

        return answer;
    }

}
