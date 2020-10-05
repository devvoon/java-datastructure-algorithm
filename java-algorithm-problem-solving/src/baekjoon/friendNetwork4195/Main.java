package baekjoon.friendNetwork4195;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> LIST = new HashMap<String, Integer>();
    static int[] PARENT, RANK, RELATION ;
    static int MAX = 100000;;

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        int testCase = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < testCase; i++) {
            int F = Integer.parseInt(br.readLine());
            int index = 0;
            
            LIST = new HashMap();
            PARENT = new int[MAX];
            RELATION = new int[MAX];
            
            Arrays.fill(RELATION, 1);
            
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                
                if (!LIST.containsValue(name1)){
                    LIST.put(name1, index);
                    PARENT[index] = index++; 
                }
                
                if (!LIST.containsValue(name2)){
                    LIST.put(name2, index);
                    PARENT[index] = index++; 
                }
                
                union(LIST.get(name1), LIST.get(name2));
            }
            
        }
        

        bw.flush();
        bw.close();
        osw.close();
        
        br.close();
        isr.close();
    }

    private static void union(int u, int v) {
        int uR = find(u);
        int vR = find(v);
                
        if (uR == vR) {
            return;
        }
            
        
    }

    private static int find(int u) {
        if (PARENT[u] == u) {
            return u;
        }
        return (PARENT[u] = find(PARENT[u]));
    }   

}
