package groom.exam43060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int[] arr = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int n = Integer.parseInt(br.readLine());
        
        TreeMap<Integer, ArrayList<Integer>> list =new TreeMap<>();
        int index=  0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if ( (arr[i]+arr[j]+arr[k] == n) && (arr[i] < arr[j]) && (arr[j] < arr[k]) && (arr[i] < arr[k])) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        
                        Collections.sort(temp);
                        
                        if (!list.containsValue(temp)){
                            list.put(index, temp);
                            index++;
                        }

                    }
                }
            }
            
        }
        
        if (list.isEmpty()) {
            System.out.println("NO");
        }else {

            for (int i = 0; i < list.size(); i++) {
                String result = "";
                int idx = 0;
                for (int num : list.get(i)) {
                    idx++;
                    result = result + num;
                    if ( idx < list.get(i).size()) {
                      result = result + " "; 
                    }
                    
                }
                System.out.println(result);
            }
        }

        br.close();

    }

}
