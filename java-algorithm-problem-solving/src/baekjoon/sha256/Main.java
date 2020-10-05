package baekjoon.sha256;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

/**
 * 10930 SHA-256 
 * 
 * [문제]
 * 문자열 S가 주어졌을 때, SHA-256 해시값을 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 문자열 S가 주어진다. S는 알파벳 대문자와 소문자, 그리고 숫자로만 이루어져 있으며, 길이는 최대 50이다.
 * 
 * [출력]
 * 첫째 줄에 S의 SHA-256 해시값을 출력한다.
 * 
 * [예제]
 * Baekjoon
 * ->9944e1862efbb2a4e2486392dc6701896416b251eccdecb8332deb7f4cf2a857
 * 
 * @reference https://www.acmicpc.net/problem/10930
 * @author iamdawoonjeong
 *
 */
public class Main {
    
    public static void main(String[] args) {
    
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
        
            String S = br.readLine();
            String sha = sha256(S);
            
            System.out.println(sha);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static String sha256(String S) {
        
        String result;
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(S.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff&hash[i]);
                if(hex.length() == 1 ) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            result = hexString.toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        //결과 반환
        return result;
    }

}
