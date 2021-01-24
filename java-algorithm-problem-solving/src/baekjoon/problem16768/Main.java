package baekjoon.problem16768;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 16768 Mooyo Mooyo
 * 
 * @references https://www.acmicpc.net/problem/16768
 * @author iamdawoonjeong
 */
public class Main {

    public static int n ; 
    public static int arr[][];
    public static boolean[][] visited, removed;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());      // n*10 grid
        int k = Integer.parseInt(st.nextToken());  // k개 이상이면 remove
        
        arr = new int[n][10];
        for (int i = 0; i < n; i++) {
            String[] ch = br.readLine().split("");
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(ch[j]);
            }
        }

        while(true) {
            boolean isExist = false;  //바뀌는게 존재 할때까지
            
            visited = new boolean[n][10];
            removed = new boolean[n][10]; // 지워도 되는가?
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    
                    if (arr[i][j] == 0 || visited[i][j]) {
                        //넘어감
                        continue;
                    }
                    
                    int result = dfs(i, j); // dfs가 맞으면 갯수세기
                    
                    if (result >= k ) {
                        dfs2(i, j, arr[i][j]); //같은수 remove
                        isExist = true; //바뀜
                    }
                    
                }
            }
            
            //바뀌는게 없을때까지 
            if (!isExist) {
                break;
            }
            
            down(); //내리기
        }
        
        //결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
    }

    public static int dfs(int i, int j) {
        
        //방향벡터 
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        
        visited[i][j] = true;
        int result = 1;
        
        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            
            //구간내 있는지 체크
            if ( nextX < 0 || nextX >= n || nextY < 0 || nextY >= 10 ) {
                continue; 
            }
            
            //지금숫자와 다음숫자가 다르거나, 방문 이력이 여부 체크
            if ((arr[nextX][nextY] != arr[i][j] )  || (visited[nextX][nextY])) {
                continue; 
            }
            result += dfs(nextX, nextY); 
            
        }
        
        return result ;
        
    }
    
    public static void dfs2(int i, int j, int  value) {
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new  int[]{1, 0, -1, 0};
        
        arr[i][j] = 0;
        removed[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            
            if ( nextX < 0 || nextX >= n || nextY < 0 || nextY>= 10) {
                continue;
            }
            
            if ((value != arr[nextX][nextY]) || removed[nextX][nextY] ) {
                continue;
            }
            dfs2(nextX, nextY, value);
        }
        
    }

    public static void down() {
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ( arr[j][i] != 0 ) {
                    temp.add(arr[j][i]);
                }
            }
            for (int j = 0; j < n-temp.size(); j++) {
                arr[j][i] = 0 ;
            }
            for (int j = n-temp.size(); j < n ; j++) {
                arr[j][i] = temp.get(j - (n - temp.size()));
            }
        }
        
    }
}

