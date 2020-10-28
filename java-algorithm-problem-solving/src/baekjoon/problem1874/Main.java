package baekjoon.problem1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1874 스택 수열
 * 
 * @reference https://www.acmicpc.net/problem/1874
 * @author iamdawoonjeong
 */
public class Main {
    public static void main(String args[]) {

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int n =  Integer.parseInt(br.readLine()); //첫 줄은 수열 갯수
            int[] arr = new int[n]; //입력받은 n으로 배열 사이즈 지정

            //배열 사이즈는 정해졌기 때문에 for문으로 입력값 배열로 생성
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            br.close();
            isr.close();
            
            int index=0;
            Stack<Integer> stack = new Stack<Integer>();
            StringBuilder sb = new StringBuilder();// append하기 위해서 StringBuilder 이용 배열은 사이즈를 알 수 없기 때문
            
            //오름차순을 하기 위해 for문 증가
            for (int i = 1; i <= n; i++) {
                stack.add(i);
                sb.append("+\n"); //+ 붙이고 예제 출력문 처럼 강제개행
                
                //arr의 값과 stack의 top의 값이 같다면 
                while(stack.peek() == arr[index]) {
                    //stack를 pop해주고  
                    stack.pop();
                    sb.append("-\n"); //- 붙이고 예제 출력문 처럼 강제개행
                    
                    //arr다음 값 비교를 위해 ++
                    index++;

                    //stack를 pop을 다 해서 비어있을 경우 루푸문 빠져나오기 
                    if(stack.isEmpty()) {
                        break;
                    }
                }
            }
            
            if(stack.isEmpty()) {
                //stack이 비어있으면 sb출력
                System.out.println(sb);
            }else {
                //stack이 비어있지않으면 정렬이 안된것이므로 NO 출력
                System.out.println("NO");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
