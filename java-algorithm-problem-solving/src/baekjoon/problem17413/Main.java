package baekjoon.problem17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 17413 단어 뒤집기 2
 * 
 * @references https://www.acmicpc.net/problem/17413
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        boolean isTag = false; 
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
    
        for (char ch : input) {
            switch (ch) {
            case ' ': {
                if (!isTag) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                }else {
                    sb.append(ch);
                }
                break;
                
            } case '<': {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isTag = true;
                sb.append(ch);
                break;
                
            } case '>': {
                isTag = false;
                sb.append(ch);
                break;
                
            } default:
                if (!isTag) {
                    stack.push(ch);
                }else {
                    sb.append(ch);
                }
                break;
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb.toString());


    }

}
