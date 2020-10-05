package baekjoon.stackSequence1874;


/**
 * 1874 스택 수열
 * 
 * [문제]
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 
 * 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
 * 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 * 
 * [입력]
 * 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
 * 물론 같은 정수가 두 번 나오는 일은 없다.
 * 
 * [출력]
 * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. 
 * push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
 * 
 * 
 * 
 * @reference https://www.acmicpc.net/problem/1874
 * @author iamdawoonjeong
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

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
