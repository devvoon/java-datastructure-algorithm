package arraylistofarraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOfArrayList {

    public static void main(String[] args) {
  
        ArrayList<ArrayList<Integer>> list =  new ArrayList<ArrayList<Integer>>(); 
        
        ArrayList<Integer> a1 = new ArrayList<Integer>(); 
        a1.add(1); 
        a1.add(2); 
        list.add(a1); 
  
        ArrayList<Integer> a2 = new ArrayList<Integer>(); 
        a2.add(5); 
        list.add(a2); 
  
        ArrayList<Integer> a3 = new ArrayList<Integer>(); 
        a3.add(10); 
        a3.add(20); 
        a3.add(30); 
        list.add(a3); 

        for (int i = 0; i < list.size(); i++) { 
            for (int j = 0; j < list.get(i).size(); j++) { 
                System.out.print(list.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        }
         
        ArrayList<ArrayList<Integer>> list2 =  new ArrayList<ArrayList<Integer>>(); 
        
        ArrayList<Integer> b1 = new ArrayList<Integer>(); 
        b1.add(5); 
        b1.add(3);
        b1.add(2); 
        b1.add(1); 
        b1.add(4); 
        list2.add(b1); 
        
        ArrayList<Integer> b2 = new ArrayList<Integer>(); 
        b2.add(10); 
        b2.add(40);
        b2.add(50); 
        b2.add(30); 
        b2.add(20); 
        list2.add(b2); 

        for (ArrayList<Integer> al : list2) {
            Collections.sort(al);
            System.out.println(al);
        }
        
    }

}
