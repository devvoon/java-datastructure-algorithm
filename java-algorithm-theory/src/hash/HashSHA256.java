package hash;

import java.security.MessageDigest;

public class HashSHA256 {

    public static void main(String[] args)  {
        
        String str  = "BaekJoon";
        hex256(str);
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            //str.getBytes("UTF-8") : UTF-8 로 인코딩  66 97 101 107 74 111 111 110 hex 2f
//            byte[] temp = str.getBytes("UTF-8");
//            
//            for (int i = 0; i < temp.length; i++) {
//                System.out.print(temp[i] + " ");
//            }
            
            //47 57 56 -37 -20 -1 -68 -46 -94 97 -125 100 -14 -105 -13 6 -118 -17 11 74 43 -66 67 69 -80 -40 -18 -27 -75 116 1 99 hex 2f
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            
            StringBuffer hexString = new StringBuffer();
            
            System.out.println();
            
            for (int i = 0; i < hash.length; i++) {
                
                //2f 39 38 db ec ff bc d2 a2 61 83 64 f2 97 f3 6 8a ef b 4a 2b be 43 45 b0 d8 ee e5 b5 74 1 63 2f3938dbecffbcd2a2618364f297f3068aef0b4a2bbe4345b0d8eee5b5740163
                String hex = Integer.toHexString(0xff&hash[i]);
                //System.out.print(hex + " ");
                if(hex.length() == 1 ) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            String result = hexString.toString();
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public static void hex256(String str) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes("UTF-8"));
            md.digest();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
