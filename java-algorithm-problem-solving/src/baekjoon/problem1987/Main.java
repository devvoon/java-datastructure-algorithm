package baekjoon.problem1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1987 알파벳
 * 
 * @references https://www.acmicpc.net/problem/1987
 * @author iamdawoonjeong
 */
public class Main {

    public static int[][]  arr;
    public static boolean[] visited;
    public static int[] dx;
    public static int[] dy;
    public static int r, c, result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());  //세로  row
        c = Integer.parseInt(st.nextToken());  //가로  col
        arr = new int[r][c];
        
        //이동좌표 (상, 하, 좌, 우)
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j)- 'A';
            }
        }
        
        visited = new boolean[r*c];
        result = 0;
        bfs(0, 0, 0);
        System.out.println(result);

    }
    
    public static void bfs(int x, int y, int depth) {
        if (visited[arr[x][y]]) {
            result = Math.max(result, depth);
            return;
        }else {
            visited[arr[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    bfs(nx, ny, depth+1);
                }
            }
            visited[arr[x][y]] = false;
        }
    }

}


