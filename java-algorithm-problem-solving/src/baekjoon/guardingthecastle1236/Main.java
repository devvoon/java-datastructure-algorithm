package baekjoon.guardingthecastle1236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //세로 col
        int M = Integer.parseInt(st.nextToken());  //가로 row

        String[][] arr = new String[N][M];
        
        int[] col = new int[N];
        int[] row = new int[M];
        
        for (int i = 0; i < N; i++) {
            String[] temp= br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j];
                if  ("X".equals(arr[i][j])){
                    col[i] = 1;
                    row[j] = 1;
                }
            }
        }

        int colCount = 0;
        for (int i = 0; i < N; i++) {
            if ( col[i] == 0) {
                colCount += 1;
            }
        }
        
        int rowCount = 0;
        for (int i = 0; i < M; i++) {
            if ( row[i] == 0) {
                rowCount += 1;
            }
        }
        
        int max = Math.max(colCount,  rowCount);
        System.out.println(max);

        br.close();
        isr.close();
    }

}
