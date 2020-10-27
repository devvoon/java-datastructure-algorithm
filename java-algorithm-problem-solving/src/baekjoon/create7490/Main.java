package baekjoon.create7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 7490 0 만들기
 * 
 * @references https://www.acmicpc.net/problem/7490
 * @author iamdawoonjeong
 */
public class Main {

    //연산자를 담을 ArrayList 의 ArrayList
    static ArrayList<ArrayList<Character>> operator; 
    
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            
            operator = new ArrayList<>();
            ArrayList<Character> list = new ArrayList<>();
            StringBuilder sb;
            
            //연산자 갯수 = 피연산자 갯수() - 1
            recursive(list, n-1);
            
            for (ArrayList<Character> op : operator) {
                sb = new StringBuilder();
                int num;
                for (num = 0; num < n-1; num++) {
                    sb.append(num+1).append(op.get(num));
                }
                sb.append(num+1);
                
                String calc = sb.toString();
                calc  = calc.replaceAll(" ", "");
                
                if (calculation(calc) == 0) {
                    System.out.println(sb);
                }
            }
            System.out.println();
        }
        
        br.close();
        isr.close();
        
    }

    /**
     * 계산로직
     * @param str
     * @return
     */
    public static int calculation(String str) {
        
        //operator 제외하고 숫자만 배열로 넣음 
        String[] num = str.split("[+\\-]");
        
        ArrayList<Character> opList = new ArrayList<>();
        
        for (Character ch : str.toCharArray()) {
            if ('+' == ch || '-' == ch) {
                opList.add(ch);
            }
        }
        
        int cal = Integer.parseInt(num[0]);
        for (int i = 1; i < num.length; i++) {
            if ( opList.get(i-1).equals('+') ) {
                cal+= Integer.parseInt(num[i]);
            }
            if ( opList.get(i-1).equals('-') ) {
                cal-= Integer.parseInt(num[i]);
            }
        }
        
        return cal;
    }

    /**
     * 연산자 조합의 모든 경우의 수를 구함
     * 완전탐색
     * @param list
     * @param n
     */
    public static void recursive(ArrayList<Character> list, int n) {
        
        if(list.size() == n ) {
            // 연산자 리스트가 n개가 되었을때 arraylist형태로 operator에 그대로 담음
            operator.add((ArrayList<Character>) list.clone());
            return;
        }

        list.add(' ');              //[ ] 으로 시작 
        recursive(list, n);         //[ ]에서 연산자들을 계속 붙임 
        list.remove(list.size()-1); //list 중 마지막 꺼를 지우고
        
        list.add('+');              // + 붙이고 다시 재귀
        recursive(list, n); 
        list.remove(list.size()-1);

        list.add('-'); // [ , -] 
        recursive(list, n);
        list.remove(list.size()-1);
    
    }

}
