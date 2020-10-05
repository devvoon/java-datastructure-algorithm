package baekjoon.friendNetwork4195;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            //테스트 케이스
            int testCase = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < testCase; i++) {
                //친구관계수
                int F = Integer.parseInt(br.readLine());
                
                //친구관계 사용자 아이디 
                Set<String> id = new HashSet<String>();
                
                //친구관계수 만큼 
                for (int j = 0; j < F; j++) {
                    
                    //한줄에 2개의 아이디 받음 
                    String[] str = br.readLine().split(" ");
                    id.add(str[0]);
                    id.add(str[1]);
                    
                    // 현재까지의 관계 수 출력 
                    System.out.println(id.size());
                }
            }
            
            br.close();
            isr.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
