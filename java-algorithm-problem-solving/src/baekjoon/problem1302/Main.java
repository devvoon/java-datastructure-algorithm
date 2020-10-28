package baekjoon.problem1302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 1302 베스트셀러
 * 
 * @references https://www.acmicpc.net/problem/1568
 * @author iamdawoonjeong
 */
public class Main {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            
            for (int i = 0; i < n; i++) {
                String name = br.readLine();

                if ( map.containsKey(name)){
                    map.replace(name,  map.get(name)+1);
                }else{
                    map.put(name, 1);
                }
                
            }

            int max = 0;
            String maxName = "";
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (value > max) {
                    max = value;
                    maxName = key;
                //maxName이 key보다 사전적으로 뒤에 갈 경우 key보다 큰값이 매겨짐. 그래서 음수가 나와야 key가 사전적으로 앞에 있는 경우가 됨 
                }else if ((value == max) && ( maxName.compareTo(key) > 0)){
                    
                    max = value;
                    maxName = key;
                }
            }
            
            System.out.println(maxName);
            
            br.close();
            isr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
