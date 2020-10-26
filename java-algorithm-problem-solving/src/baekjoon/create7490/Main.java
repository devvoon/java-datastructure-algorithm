package baekjoon.create7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

import javax.script.ScriptException;

public class Main {

    static LinkedList<String> operator; 
    
    public static void main(String[] args) throws NumberFormatException, IOException, ScriptException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
        isr.close();
        
        for (int i = 0; i < testCase; i++) {

            //연산자 리스트
            operator =  new LinkedList<String>();
            recursive(new LinkedList<String>(), arr[i]-1);
 
            /* + | + | + | - | - |   | - | + | + | - | - |   |   | + | + | - | - |   | 
            Iterator<String> its = operator.iterator();
            while(its.hasNext()) {
                System.out.print(its.next() + " | ");
            }*/ 

            //피연산자 배열
            int[] operand = new int[arr[i]];
            for (int j = 1; j < operand.length+1; j++) {
                operand[j-1] = j; 
            }
            
            //연산자와 피연산자 붙이기
            Iterator<String> it = operator.iterator();
            String op = "";
            int cal = 0;
            int count = 0;
            int n = (operator.size() / (arr[i]-1)); //반복 횟수 = operator 사이즈 / 숫자갯수-1 
            
            LinkedList<String> oplist = null;
            LinkedList<Integer> numlist = null;
            
            for (int j = 0; j < n; j++) {
                oplist = new LinkedList<String>();
                numlist = new LinkedList<Integer>();
                
                StringBuilder sb = new StringBuilder();
                boolean blank = false;
                
                //피연산자 갯수만큼 반복
                for (int k = 0 ; k < operand.length ; k++) {
                    
                    //피연산자 넣기 
                    numlist.add(operand[k]);
                    //출력 내용넣기
                    sb.append(operand[k]);
                    
                    if (k < arr[i]-1){
                        op = it.next();
                        sb.append(op);
                        
                        if (op.equals(" ")) {
                            blank= true;
                            //" " 공백 연산자 만났을 경우 다음 연산자랑 붙여서 넣기
                            int current = operand[k];
                            int next = operand[k+1];
                            String temp = Integer.toString(current) + Integer.toString(next); 
                            numlist.remove(k);
                            numlist.add(Integer.parseInt(temp));
                            //k++;
                            //count++;
                            
                        }else {
                            //연산자 넣기
                            oplist.add(op);
                            
                        }

                    }
                    count++;
                }
                
                System.out.println(sb.toString() + " : " + numlist + " : " + oplist );
                
                
                /*
                if (count == operand.length) {
                    
                    for (int p = 0; p < numlist.size()-1; p++) {
                        cal = cal + numlist.get(p);
                        
                        switch (oplist.get(p)) {
                        case "+": {
                            cal = cal + numlist.get(p+1);
                            break;
                        }
                        case "-": {
                            cal = cal - numlist.get(p+1);
                            break;
                        }
                        default:
                            System.out.println("error : " + op);
                            throw new IllegalArgumentException("Unexpected value: " + op);
                        }

                    }
                    
                    if (0 == cal) {
                        System.out.println(sb.toString());
                    }
                    cal = 0;
                    count = 0;
                }*/

            }
       
        }
    }



    public static void recursive(LinkedList<String> list, int n) {
        
        if (list.size() == n ) {
            // 연산자 리스트를 만들고 operator에다가 넣어주기 
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String str = it.next();
                operator.add(str);
            }
            return;
        }
        
    
        // +, -, ' ' 세개의 연산이 들어갈 수 있음 (3) 
        list.add(" ");
        recursive(list, n);
        list.pop();
        
        list.add("+");
        recursive(list, n);
        list.pop();
        
        
        list.add("-");
        recursive(list, n);
        list.pop();

        
    }

}
