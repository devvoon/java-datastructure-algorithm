package baekjoon.problem5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 5397 키로거 
 * 
 * @reference https://www.acmicpc.net/problem/5397
 * @author iamdawoonjeong
 */
public class Main2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split("");
            
            Stack<String> left = new Stack<String>();
            Stack<String> right = new Stack<String>();
            
            for (int j = 0; j < input.length; j++) {
                
                if ("<".equals(input[j])) {
                    if (!left.isEmpty()) {
                        right.add( left.pop());
                    }
                    
                }else if (">".equals(input[j])) {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    
                }else if("-".equals(input[j])) {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    
                }else {
                    left.push(input[j]);
                }
            }
            
            StringBuilder sb = new StringBuilder();

            for (String string : left) {
                sb.append(string);
            }
             
            while(!right.isEmpty()) {
                sb.append(right.pop());
            }
            
            System.out.println(sb.toString());
        }

    }

}
