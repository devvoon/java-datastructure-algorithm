package baekjoon.problem16165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *  16165 걸그룹 마스터 준석이
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/16165
 *
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //입력받는 걸그룹의수 
        int M = Integer.parseInt(st.nextToken());  //맞춰야할 문제
        
        HashMap<String, String[]> teams = new HashMap<String, String[]>();
        HashMap<String, String> members = new HashMap<String, String>();
        
        
        //걸그룹 입력받기
        for (int i = 0; i < N; i++) { 
            
            String team = br.readLine();  //팀의이름
            int number = Integer.parseInt(br.readLine()); //걸그룹 인원수
            
            String[] names = new String[number];
            for (int j = 0; j < number; j++) {
                names[j] = br.readLine();  //멤버들 이름
                members.put(names[j], team);
            }
            
            Arrays.sort(names);
            teams.put(team, names);
        }
        
        //문제맞추기
        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            int type = Integer.parseInt(br.readLine());
           
           //팀명제시 : 멤버이름 순차적 
           if (type == 0) {
               String[] resultNames = teams.get(problem);
               for (int j = 0; j < resultNames.length; j++) {
                   System.out.println(resultNames[j]);
               }
           }else if (type == 1) {
              // 멤버이름 제시 : 팀명 맞추기
               String resultTeam = members.get(problem);
               System.out.println(resultTeam);
           }
            
        }

    }

}
