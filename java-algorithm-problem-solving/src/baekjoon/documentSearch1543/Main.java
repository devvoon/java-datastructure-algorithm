package baekjoon.documentSearch1543;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1543 문서 검색
 * 
 * @references https://www.acmicpc.net/problem/1543
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            String doc = br.readLine();
            String word = br.readLine();
            
            int length = word.length();
            
            int index=0;
            int count=0;
            
            while(index+length <= doc.length() ) {
                
                String str = doc.substring(index, index+length);

                if ( word.equals(str)) {
                    index += length;
                    count++;
                    
                }else {
                    index++;
                }
            }
            
            System.out.println(count);

            br.close();
            isr.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
