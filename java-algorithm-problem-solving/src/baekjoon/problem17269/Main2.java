package baekjoon.problem17269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  17269 이름궁합 테스트 - 배열 사용 
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/17269
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st=  new StringTokenizer(br.readLine());
        char[] namea = st.nextToken().toCharArray();
        char[] nameb = st.nextToken().toCharArray();
        
        //Alphabet
        int[] alpa = { 3, 2, 1, 2, 4
                     , 3, 1, 3, 1, 1
                     , 3, 1, 3, 2, 1
                     , 2, 2, 2, 1, 2
                     , 1, 1, 1, 2, 2
                     , 1};

        int[] name = new int[n+m];
        
        int i = 0;
        int j = 0;
        int index = 0;
        
        while(i < n || j  < m) {
            if(i < n) {
                name[index] = alpa[namea[i]-'A'];
                i++;
                index++;
            }
            
            if (j < m) {
                name[index] = alpa[nameb[j]-'A'];
                j++;
                index++;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k : name) {
            list.add(k);
        }
        
        solution(list);
    }

    public static void solution(ArrayList<Integer> list) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < list.size()-1; i++) {
            int sum = list.get(i) + list.get(i+1);
            if (sum>10) {
                sum=sum%10;
            }
            result.add(sum);
        }
        
        if (result.size() !=2) {
            solution(result);
        }else {
            System.out.println(String.format("%s", ((result.get(0)%10)*10) + result.get(1)%10 )+ "%");
        }
        
    }

}
