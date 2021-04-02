package baekjoon.problem1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1966 프린트큐
 * @reference https://www.acmicpc.net/problem/1966
 * @author iamdawoonjeong
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Integer[] priority = new Integer[n];
            
            String[] input = br.readLine().split(" ");
            Queue<Integer> queue = new LinkedList<Integer>();
            
            for (int j = 0; j < n; j++) {
                priority[j] = Integer.parseInt(input[j]);
                queue.add(priority[j]);
            }

            int doc = priority[m]; //5
            
            //내림차순 정렬
            Arrays.sort(priority, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
            
            int maxIndex = 0;
            int max =  priority[maxIndex];
            int index = m;
            int count = 0;
            
            
            while (true) {
                
                if (queue.peek() == max ) {

                    count++;
                    if (queue.peek() == doc && max == doc && index==0) {
                        break;
                        
                    }else {
                        queue.poll();
                        
                        index--;
                        maxIndex++;
                        max = priority[maxIndex];
                    }
                    
                }else {
                    int temp  = queue.poll();
                    queue.add(temp);
                    
                    if (index ==0) {
                        index = queue.size()-1;
                    }else {
                        index--;
                    }
                    
                }
            
            }
            
            System.out.println(count);
        }

    }

}
