package baekjoon.problem1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1966 프린트큐
 * @reference https://www.acmicpc.net/problem/1966
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            //head : 테스트 케이스의 수 
            int testCase = Integer.parseInt(br.readLine());
            
            //테스트별 결과 담는 배열선언
            int[] result = new int[testCase];
            
            for (int i = 0; i < testCase; i++) {
                
                //첫번째 줄  
                String[] str = br.readLine().split(" ");
                int N = Integer.parseInt(str[0]);   //문서의 수
                int M = Integer.parseInt(str[1]);   //몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치에 있는지를 알려주는 M(0이상 N미만)
                
                //두번째 줄 :  N개 문서의 중요도
                String[] arr = br.readLine().split(" ");
                
                //문제 풀기
                result[i] = solution(N, M, arr);
            }
            
            br.close();
            isr.close();
            
            //결과 출력
            print(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int solution(int N, int M, String[] arr) {
        
        // 입력된 우선순위를 queue에 넣어줌
        Queue<Integer> queue =  new LinkedList<Integer>();
        for (int j = 0; j < N; j++) {
            queue.add(Integer.parseInt(arr[j]));
        }
        
        int count = 0;   // 출력횟수 (몇번째로 출력되나?)

        
        int index = M;   // queue가 index를 지원하지 않아서 출력순서 찾아야할 위치를 따로 관리 
        int result = 0;  // 출력순서 결과값 따로 담기 
        int target = Integer.parseInt(arr[M]);  //M번째 위치해있는 우선순위 (내가 출력순서를 찾아야 할 우선순위) 

        Arrays.sort(arr); // 입력된 배열을 정렬해서 이용해줌 (원래 배열은 queue에 담에서 사용)
        int maxIndex = arr.length-1;
        int max = Integer.parseInt(arr[maxIndex]); //최대값
        
        while (true) {
            
            //1. 출력되는 경우 : 우선순위 값 == head의 값 같음 
            if (queue.peek() == max) {
                
                // 내가 원하는걸 찾았 을 때 
                if (( max == target )  && (queue.peek() == target) && (index == 0)) {
                    result =   ++count;
                    break;
                }else {
                // 찾지 못했으나, 우선수위 임으로 출력
                    queue.poll(); 
                    count++;
                    
                    index--; //찾는게 한자리 앞으로 움직임 
                    maxIndex--; ; //맥스값도 하나 낮아짐
                    max = Integer.parseInt(arr[maxIndex]);
                }

            } else if (queue.peek() < max) {
            //2. 출력되지 않는 경우 : 우선순위 작은거 만났을때-> queue에서 dequeue 후 inqueue해주기  
                
                //queue head에서 poll로 뽑은 후 
                int temp = queue.poll();
                //다시 넣어줌 
                queue.add(temp);
                
                //내가 찾아야하는 문서가 우선순위가 낮아서 다시 뒤로가야하는경우
                if (index==0) {
                    //index값 재조정 (남은 배열 갯수 맨 뒷자리로 가게 되어있음)
                    index = N-1-count; 
                }else {
                    index--;
                }
                
            }
        }
        return result;
    }

    private static void print(int[] result) {
        for (int i : result) {
            System.out.println(i);
        }
    }
    
}
