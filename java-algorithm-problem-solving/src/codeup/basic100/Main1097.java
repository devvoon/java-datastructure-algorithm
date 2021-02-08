package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1097 : [기초-2차원배열] 바둑알 십자 뒤집기(설명) 
 *  
 * @references https://codeup.kr/problem.php?id=1097
 * @author iamdawoonjeong
 */
public class Main1097 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] arr = new int[20][20];
        StringTokenizer st = null; 
        
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        
        int n = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int j = 1; j < 20; j++) {
                if (arr[x][j] == 0) {
                    arr[x][j] = 1;
                }else {
                    arr[x][j] = 0;
                }
                
            }
            
            for (int j = 1; j < 20; j++) {
                if (arr[j][y] == 0) {
                    arr[j][y] = 1;
                }else {
                    arr[j][y] = 0;
                }
            }
        }
        
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


}
