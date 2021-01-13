package baekjoon.problem1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1080 행렬
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1080
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        //입력
        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                A[i][j]  = Integer.parseInt(str[j]); 
            }
        }
        
        int[][] B = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                B[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        int result = 0;
        
        //뒤집히는 좌표가 3*3 행렬이기 때문에 n-2, m-2 만큼 돌아야함 
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                //같은 좌표의 값이 다른경우 
                if (A[i][j] != B[i][j]) {
                    //뒤집기
                    flip(i,j,A);
                    result += 1;//flip한 횟수
                     
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != B[i][j]) {
                    result = -1;
                    break;
                }
            }
        }
        
        System.out.println(result);
    }

    /**
     * 뒤집기 
     * @param i
     * @param j
     * @param A
     */
    private static void flip(int i, int j, int[][] A) {
        
        //현좌표에서 3*3까지만 뒤집어주기 
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                A[i+x][j+y] ^=1;  //XOR 1이 홀수개 1, 1이 짝수개  0
            }
        } 
    }

}
