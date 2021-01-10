package baekjoon.problem1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 1092 배
 * 
 * @references https://www.acmicpc.net/problem/1092
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Integer[] cranes = new Integer[n]; //크레인 
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        
        //내림차순 정렬
        Arrays.sort(cranes, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] box = new Integer[m];  //박스
        for (int i = 0; i < box.length; i++) {
            box[i] = Integer.parseInt(st.nextToken()); 
        }
        
        //내림차순 정렬
        Arrays.sort(box, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
            
        });
        
        //박스가 크레인보다 무거울 경우 옮기지 못 함 
        if (box[0] > cranes[0]) {
            System.out.println(-1);
            return ;
        }
        
        int result = 0;
        int count = 0;
        int[] position = new int[n];   // 각 크레인이 옮겨야하는 박스의 번호
        boolean[] checked = new boolean[m];   //박스 옮겼는지 여부 
        
        while(true) {
            //박스 다 옮겼으면 종료 
            if(count == box.length) {
                break;
            }
            
            //모든 크레인에 대한 처리
            for (int i = 0; i < n; i++) {
            
               //아직 안 옮긴 박스 중에서 , 옮길 수 있는 박스를 만날 때까지 반복
                while(position[i] < box.length) {
                    
                    //박스를 0번부터 옮기며, 크레인이 박스의 보다 무거워야 옮기는 것 가능 
                    if (!checked[position[i]] && cranes[i] >= box[position[i]]){
                        
                        checked[position[i]] = true; //옮긴 박스는 옮겼다고 체크하고  
                        position[i] += 1;  // 다음박스를 옮기자
                        count++; // 옮긴 박스 카운트 
                        break;  //
                    }
                    position[i] += 1; //if 조건을 타지 못했으므로.. 다음박스를 옮기자
                }
            }
            result +=1; // 크레인 3개 한번에 동시에 사용했으므로, 1분 경과
        }
        System.out.println(result);
        
    }
}
