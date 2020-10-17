package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortAPI {

    public static void main(String[] args) {
        
        // arrays - 숫자 오름차순 
        System.out.println("** Sorting Int an array in ascending order: Arrays.sort()");
        Integer[] arr = new Integer[5];
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 1;
        arr[3] = 4;
        arr[4] = 2;
        
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        
        // arrays - 숫자 내림차순 
        System.out.println("** Sorting Int an array in descending order : Arrays.sort(new Comparator<String>())");
        
        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        
        for (int i : arr) {
            System.out.println(i);
        }
        
        // arrays - 문자 오름차순 
        System.out.println("** Sorting String an array in ascending order: Arrays.sort()");
        String[] arr2 = new String[5];
        arr2[0] = "new";
        arr2[1] = "apple";
        arr2[2] = "mouse";
        arr2[3] = "notebook";
        arr2[4] = "smart phone";
        
        Arrays.sort(arr2);
        for (String string : arr2) {
            System.out.println(string);
        }
        
        // arrays - 문자 내림차순 
        System.out.println("** Sorting Integer an array in descending order: Arrays.sort()");
        Arrays.sort(arr2, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (String string : arr2) {
            System.out.println(string);
        }
        
        // collections - 숫자 오름차순
        System.out.println("** Sorting integer an ArrayList in ascending order: Collections.sort()");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        // collections - 숫자 내림차순
        System.out.println("** Sorting an ArrayList in descending order : Collections.sort(Collections.reverseOrder()) ");

        Collections.sort(list, Collections.reverseOrder());
        for (Integer integer : list) {
            System.out.println(integer);
        }
        
        // collections - 문자 오름차순
        System.out.println("** Sorting an ArrayList in ascending order: Collections.sort()");
        
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("new");
        list2.add("apple");
        list2.add("mouse");
        list2.add("notebook");
        list2.add("smart phone");
        
        Collections.sort(list2);
        for (String string : list2) {
            System.out.println(string);
        }
        
        // collections - 문자 오름차순
        System.out.println("** Sorting an ArrayList in descending order : Collections.sort(Collections.reverseOrder()) ");
        
        Collections.sort(list2, Collections.reverseOrder());
        for (String string : list2) {
            System.out.println(string);
        }
    }

}
