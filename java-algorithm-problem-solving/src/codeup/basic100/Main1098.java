package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1098 : [기초-2차원배열] 설탕과자 뽑기
 *  
 * @references https://codeup.kr/problem.php?id=1098
 * @author iamdawoonjeong
 */
public class Main1098 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken()); //세로(h)
        int w = Integer.parseInt(st.nextToken()); //가로(w)

        int[][] arr = new int[h+1][w+1];
        
        int n = Integer.parseInt(br.readLine()); //막대의 개수(n)
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());  //막대의 길이(l)
            int d = Integer.parseInt(st.nextToken());  //방향 (d:가로는 0, 세로는 1)
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < l; j++) {
                if (d==0) {
                    arr[x][y+j] = 1;
                }else {
                    arr[x+j][y] = 1;
                }
            }
        }
        
        for (int i = 1; i < h+1; i++) {
            for (int j = 1; j < w+1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
