package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lessons12933 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        long answer = solution(118372);
        System.out.println(answer);

    }

    public static long solution(long n) {
        long answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        String [] arr =  Long.toString(n).split("");

        for (String str : arr) {
            
            list.add(Integer.valueOf(str));
            
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        String str = "";
        
        for(int i : list) {
            str = str + Integer.toString(i);
        }
        answer = Long.valueOf(str);
        
        return answer;
    }

}
