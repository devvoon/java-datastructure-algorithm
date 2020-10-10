package ioStream;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Enter an integer"); 
        int a = sc.nextInt(); 
        System.out.println("Enter a String"); 
        String b = sc.nextLine(); 
        System.out.printf("You have entered:- "+ a + " " + "and name as " + b); 

    }

}
