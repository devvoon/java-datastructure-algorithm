package baekjoon.problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int count = 0;
        int n = input;
        
        while ( n > 1) {
            
            if (n%3 == 0 ) {
                n=n/3;
            }else if(n%2 == 0){
                n=n/2;
            }else {
                n--;
            }
            
            count++;
            
            if ( n == 1) {
                break;
            }else if (n < 1){
                n = input-1;
                count=1;
            }
            
        }
    
        System.out.println(count);

    }

}
