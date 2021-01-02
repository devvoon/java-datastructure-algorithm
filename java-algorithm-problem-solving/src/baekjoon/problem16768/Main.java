package baekjoon.problem16768;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n ; 
    static int arr[][];
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr = new int[n][10];
        for (int i = 0; i < n; i++) {
            String[] ch = br.readLine().split("");
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(ch[j]);
            }
        }

        boolean[][] visited = new boolean[n][10];
        
        while(true) {
            boolean exist = false;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    
                    if (arr[i][j] == 0 && visited[i][j]) {
                        continue;
                    }
                    
                    int result = dfs(i, j, visited);
                    
                    if (result >= k ) {
                        dfs2(i, j); //같은수 remove
                        exist = true;
                    }
                    
                }
            }
            
            if (!exist) {
                break;
            }
        }

        
    }

    private static void down() {
        // TODO Auto-generated method stub
        
    }


    public static int dfs(int i, int j, boolean[][] visited) {
        
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        
        visited[i][j] = true;
        int result = 1;
        
        for (int k = 0; k < dy.length; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            
            if ( nextX < 0 || nextX > n || nextY < 0 || nextY > 10 ) {
                continue;
            }
            
            if ((arr[nextX][nextY] != arr[i][j] )  && (visited[nextX][nextY])) {
                continue;
            }
            
            result += dfs(nextX, nextY , visited); 
            
        }
        
        return result ;
        
    }
    
    private static void dfs2(int i, int j) {
        
    }


}

