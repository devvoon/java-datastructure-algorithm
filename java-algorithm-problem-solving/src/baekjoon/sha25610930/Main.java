package baekjoon.sha25610930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

/**
 * 10930 SHA-256 
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
