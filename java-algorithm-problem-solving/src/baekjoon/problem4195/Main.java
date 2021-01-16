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
    static int MAX = 200002;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCase; i++) {
            int F = Integer.parseInt(br.readLine());
            
            List = new HashMap<String, Integer>();
            Parent = new int[MAX];
            Number = new int[MAX];
            
            int index =0;
            
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                
                if (!List.containsKey(name1)) {
                    List.put(name1, index);
                    Parent[index] = index;
                    Number[index] = 1;
                    index++;
                }
                
                if (!List.containsKey(name2)) {
                    List.put(name2, index);
                    Parent[index] = index;
                    Number[index] = 1;
                    index++;
                }
                
                unioun(List.get(name1), List.get(name2));
                bw.write(Number[find(List.get(name1))]+"\n");
            }
        }
        
        
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void unioun(int x, int y) {
        int xR = find(x);
        int yR = find(y);
        
        if( xR != yR) {
            Parent[yR] = xR;
            Number[xR] += Number[yR];
        }
    }

    public static int find(int x) {
        if ( x== Parent[x]) {
            return x;
        }else {
            int p = find(Parent[x]);
            Parent[x] = p;
            return Parent[x];
        }
    
    }

   
}
