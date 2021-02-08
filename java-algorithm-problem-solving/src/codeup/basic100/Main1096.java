package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1096 : [기초-2차원배열] 바둑판에 흰 돌 놓기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1096
 * @author iamdawoonjeong
 */
public class Main1096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[20][20];
        StringTokenizer st = null; 
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            arr[x][y] = 1;
        }
        
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
