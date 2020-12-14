package baekjoon.problem16956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  16956 늑대와 양
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/16956
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken()); //row
        int c = Integer.parseInt(st.nextToken()); //col
        String[][] arr = new String[r][c];
         
        for (int i = 0; i < r; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = temp[j];
            }
        } 
        
        //시계방향체크 동,남,서,북
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        boolean check = false;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //늑대의 위치에서 
                if ("W".equals(arr[i][j])) {
                    //시계방향으로 이동 해보기 
                    for (int k = 0; k < dx.length; k++) {
                        int nextx = i + dx[k];
                        int nexty = j + dy[k];
                        
                        if (nextx < 0 || nextx == r || nexty < 0 || nexty ==c) {
                            continue;
                        }
                        
                        //이동했는데 양이 있다면 
                        if ("S".equals(arr[nextx][nexty])) {
                            //울타리 설치가 무의미
                            check = true;
                        }
                    }
                }
            }
        }
        
        if (check){
            //울타리 설치 무의미한 경우 0출력 
            System.out.println(0);
        }else {
            //울타리를 설치할 수 있는 경우 1출력 
            System.out.println(1);
            //최소 울타리갯수를 구하는게 아니므로 
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if ( !(arr[i][j].equals("W")) &&  !(arr[i][j].equals("S"))) {
                        //모두 자리에 울타리 설치
                        arr[i][j] = "D";
                    }
                }
            }
            
            //출력 
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }

    }

}
