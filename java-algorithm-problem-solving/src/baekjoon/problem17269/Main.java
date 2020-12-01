package baekjoon.problem17269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *  17269 궁합
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/17269
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        String[] A= st.nextToken().split("");
        String[] B = st.nextToken().split("");

        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("A", 3);
        map.put("B", 2);
        map.put("C", 1);
        map.put("D", 2);
        map.put("E", 4);
        map.put("F", 3);
        map.put("G", 1);
        map.put("H", 3);
        map.put("I", 1);
        map.put("J", 1);
        map.put("K", 3);
        map.put("L", 1);
        map.put("M", 3);
        map.put("N", 2);
        map.put("O", 1);
        map.put("P", 2);
        map.put("Q", 2);
        map.put("R", 2);
        map.put("S", 1);
        map.put("T", 2);
        map.put("U", 1);
        map.put("V", 1);
        map.put("W", 1);
        map.put("X", 2);
        map.put("Y", 2);
        map.put("Z", 1);
        

        String[] names= new String[N+M];
        int i = 0;
        int j = 0;
        int index = 0;

        while(i < N || j < M) {
            
            if (i < N) {
                names[index] = A[i];
                index++;
                i++;
            }
            
            if ( j < M) {
                names[index] = B[j];
                index++;
                j++;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int k = 0; k < names.length; k++) {
            list.add(map.get(names[k]));
        }
        
        solution(list);
        
    }
    
    public static void solution(ArrayList list) {

        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < list.size()-1; i++) {
            int sum = (int) list.get(i) + (int) list.get(i+1);
            int input = sum;
            if (sum >= 10) {
                input %= 10;
            }
            result.add(input);
        }

        
        if (result.size() != 2 ) {
            solution(result);
        }else {
            
            System.out.println(String.format("%s", (int)result.get(0)%10*10 + result.get(1)%10) + "%");  
        }

    }

}
