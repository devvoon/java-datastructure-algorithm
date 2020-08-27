package hash;

import java.util.HashMap;
import java.util.HashSet;

public class HashMain {

    public static void main(String[] args)
    {
        //HashMap
        System.out.println("=====[ Hash Map ]=====");
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        
        //put key-value
        hashMap.put(2, "서울");
        hashMap.put(31, "경기");
        hashMap.put(33, "강원");
        hashMap.put(61, "전남");
        hashMap.put(51, "부산");
        System.out.println(hashMap);
        
        //중복된 key에 대한 value는 replace가 됨
        System.out.println("-----중복 된 key 넣은 후-----");
        hashMap.put(2, "서울특별시");
        System.out.println(hashMap);

        //하나의 null key만 허용
        hashMap.put(null, "아무도");
        hashMap.put(null, "아무시");
        System.out.println("-----key에 null을 넣은 후-----");
        System.out.println(hashMap);
        
        //value는 여러개 null 허용
        hashMap.put(123, null);
        hashMap.put(456, null);
        System.out.println("-----value에 null을 넣은 후-----");
        System.out.println(hashMap);
        
        System.out.println();
        System.out.println("=====[ Hash Set ]=====");
        //Hash Set
        HashSet<String> hashSet = new HashSet<String>();
        
        hashSet.add("서울");
        hashSet.add("경기");
        hashSet.add("강원");
        hashSet.add("전남");
        hashSet.add("부산");
        System.out.println(hashSet);

        //중복 
        hashSet.add("서울");
        System.out.println("-----중복 된 값 넣은 후-----");
        System.out.println(hashSet);
        
        //null 값은 한 번만 허용
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("-----null values 넣은 후-----");
        System.out.println(hashSet);  
    }



}
