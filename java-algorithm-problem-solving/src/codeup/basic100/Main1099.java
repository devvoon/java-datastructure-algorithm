package codeup.basic100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1099 {

    public static void main(String[] args) throws IOException {
        int[][] arr = new int [11][11];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        //미로 상자의 구조가 0(갈 수 있는 곳), 1(벽 또는 장애물)로 주어지고, 먹이가 2로 주어질 때, 성실한 개미의 이동 경로를 예상
        for (int i = 1; i < 11; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 11; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 개미는 (2, 2)에서 출발
        solution(arr, 2, 2);
        
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void solution(int[][] arr, int x, int y) {
        
        //현재 위치가 2인경우 종료 
        if (arr[x][y] == 2) {
            arr[x][y] = 9;
        }
        
        arr[x][y] = 9; //성실한 개미가 이동한 경로를 9로 표시해 출력
        
        //방향벡터
        int[] dx = new int[] {0,1};
        int[] dy = new int[] {1,0};

        //오른쪽
        int nextX = x+dx[0];
        int nextY = y+dy[0];
        
        //아래쪽으로만 움직임 
        if (arr[nextX][nextY] == 1) {
            nextX = x+dx[1];
            nextY = y+dy[1];
        }

        // 다음이 0 이거나 2인경우에만 움직임
        if ( arr[nextX][nextY] == 0 || arr[nextX][nextY] == 2){
            solution(arr, nextX , nextY);
        } 

    }

}
