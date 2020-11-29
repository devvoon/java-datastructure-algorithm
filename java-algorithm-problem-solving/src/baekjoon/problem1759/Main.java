package baekjoon.problem1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  1759 암호 만들기
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1759
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] arr = new String[c];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }
        
        // 암호를 사전순으로 출력해야 하기 때문에 정렬  
        Arrays.sort(arr);
        
        dfs(l, arr, "" , 0);

    }
    
    public static void dfs(int l, String[] arr, String password, int index) {
        
        //길이가 l인 모든 조합 찾기  
        if (password.length() == l) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }
        
        if (index >= arr.length) {
            return;
        }
        
        dfs(l, arr, password+arr[index], index+1);
        dfs(l, arr, password, index+1);
    }
    
    public static boolean check(String password) {
        
        int vowel=0; //모음
        int consonant=0;//자음 
        for(char arr : password.toCharArray()) {
            if(arr== 'a' || arr=='e' || arr=='i' || arr=='o' || arr=='u') {
                vowel++;
            }
            else {
                consonant++;
            }
        }
        
        // 모음 갯수 확인
        return vowel>=1 && consonant>=2;
    }

}



