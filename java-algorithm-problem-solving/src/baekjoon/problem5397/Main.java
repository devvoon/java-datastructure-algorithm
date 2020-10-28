package baekjoon.problem5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 5397 키로거 
 * 
 * @reference https://www.acmicpc.net/problem/5397
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {

        try {
            
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            int testCase= Integer.parseInt(br.readLine());
            String result[] = new String[testCase];
            
            //문제풀기
            for (int i = 0; i < testCase; i++) {
                String str = br.readLine();
                result[i] = solution(str);
            }
            
            //출력
            for (int i = 0; i < testCase; i++) {
                System.out.println(result[i]);
            }

            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String solution(String str) {
        Stack<Character> leftStack = new Stack<Character>();
        Stack<Character> rightStack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        
        char[] word = str.toCharArray();
        
        
        for (char c : word) {
            switch (c) {
            case '-': {
                
                if (!leftStack.isEmpty()){
                    leftStack.pop();
                }
                break;
                
            } case '<' :{
                
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
                break;
                
            } case '>' :{
                
                if(!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
                break;
                
            }
            default:
                leftStack.push(c);
                break;
            } 
            
        }
        
        for (Character ch : leftStack) {
            sb.append(ch);
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
            
        }
        return sb.toString();
        
    }

}
