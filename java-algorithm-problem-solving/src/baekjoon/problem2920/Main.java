package baekjoon.problem2920;

import java.util.Scanner;

/**
 * 2920 음계
 * 
 * @reference https://www.acmicpc.net/problem/2920
 * @author iamdawoonjeong
 */
public class Main {
    
    public static void main(String[] args) {
        
         //자바 표준 입력을 통해 숫자 입력 받기
         Scanner sc = new Scanner(System.in);
         String strings = sc.nextLine();
         sc.close();
         
         String arr[]  = strings.split(" ");
         
         boolean ascending = false;
         boolean descending = false;

         for (int i = 1; i < arr.length; i++) {
             if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i-1])) {
                 ascending = true;
             }else if (Integer.parseInt(arr[i]) < Integer.parseInt(arr[i-1])) {
                 descending = true;
             }
         }

         if (ascending && descending) {
             System.out.println("mixed");
         } else if (ascending){
             System.out.println("ascending");
         }else if (descending) {
             System.out.println("descending");
         }
    }

}
