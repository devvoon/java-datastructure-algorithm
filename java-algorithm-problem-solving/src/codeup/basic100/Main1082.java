package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1082 : [기초-종합] 16진수 구구단?
 *  
 * @references https://codeup.kr/problem.php?id=1082
 * @author iamdawoonjeong
 */
public class Main1082 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine() ;
        int n = Integer.valueOf(input, 16); //16진수로 입력받기 
        
        for (int i = 1; i < 16; i++) {
            //System.out.println(n + "*"  + i  + "=" + (n*i) );
            String toHex = Integer.toHexString(i).toUpperCase(); 
            int cal = n*i;
            String toCal = Integer.toHexString(cal).toUpperCase();
            System.out.println(input+ "*"  +  toHex + "=" + toCal);
        }

    }

}
