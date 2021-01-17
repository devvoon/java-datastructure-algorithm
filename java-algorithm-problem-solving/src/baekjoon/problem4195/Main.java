package baekjoon.problem4195;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 4195 친구네트워크
 * 
 * @references https://www.acmicpc.net/problem/4195
 * @author iamdawoonjeong
 */
public class Main {
    
    static Map<String, Integer> List;
    static int[] Parent, Number;
    static int MAX = 200002;  //사람 수 만 큼 (친구관계수가 100000 을 넘지않고, 한줄에 2명씩들어가서 최대값 잡아줌) 
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCase; i++) {
            int F = Integer.parseInt(br.readLine());
            
            List = new HashMap<String, Integer>();
            Parent = new int[MAX];
            Number = new int[MAX];
            
            int index =0; //입력되는 이름을 index 숫자로 관리
            
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                
                //입력된 이름 중에 중복여부 체크
                if (!List.containsKey(name1)) {

                    List.put(name1, index);   // 이름을 index로 관리 
                    Parent[index] = index;    // 처음에는 부모는 자기자신으로 갖음
                    Number[index] = 1;        // 각 노드가 갖는 연결된 갯수
                    index++;
                }
                
                if (!List.containsKey(name2)) {
                    List.put(name2, index);
                    Parent[index] = index;
                    Number[index] = 1;
                    index++;
                }
                
                //각 줄에서 입력 된 이름의 관계성을 찾아 만들어주기 (name1 은 name2의 부모)
                unioun(List.get(name1), List.get(name2));
                bw.write(Number[find(List.get(name1))]+"\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void unioun(int x, int y) {
        //관계의 갯수를 찾아 줌
        
        int xR = find(x); //입력된 노드의 부모찾기 
        int yR = find(y);
        
        //부모가 갖지 않으면 
        if( xR != yR) {
            //y의 부모를 x라 정해주고
            Parent[yR] = xR;
            //x에 연결된 갯수 = 기존 x에 연결된 갯수 + y에 연결된 갯수
            Number[xR] += Number[yR];
        }
    }

    public static int find(int x) {
        //부모를 찾아줌
        if ( x == Parent[x]) {
            return x;
        }else {
            int p = find(Parent[x]);
            Parent[x] = p;
            return Parent[x];
        }
    }

}
