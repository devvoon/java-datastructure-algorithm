package baekjoon.printQueue1966;

/**
 * 1966 프린트큐
 * 
 * [문제]
 * 여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다. 
 * 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 
 * 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
 * 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
 * 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 
 * 그렇지 않다면 바로 인쇄를 한다.
 * 예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
 * 여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 
 * 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.
 *
 * [입력]
 * 첫 줄에 test case의 수가 주어진다. 
 * 각 test case에 대해서 문서의 수 N(100이하)와 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치에 있는지를 알려주는 M(0이상 N미만)이 주어진다. 
 * 다음줄에 N개 문서의 중요도가 주어지는데, 중요도는 1 이상 9 이하이다. 
 * 중요도가 같은 문서가 여러 개 있을 수도 있다. 위의 예는 N=4, M=0(A문서가 궁금하다면), 중요도는 2 1 4 3이 된다.
 *
 * [출력]
 * 각 test case에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
 * 
 * [예제]
 * 3
 * 1 0
 * 5
 * 4 2
 * 1 2 3 4
 * 6 0
 * 1 1 9 1 1 1
 * ->
 * 1
 * 2
 * 5
 * 
 * @reference https://www.acmicpc.net/problem/1966
 * @author iamdawoonjeong
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
