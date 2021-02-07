package codeup.basic100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1084 : [기초-종합] 빛 섞어 색 만들기(설명)   
 *  
 * @references https://codeup.kr/problem.php?id=1084
 * @author iamdawoonjeong
 */
public class Main1084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int  j= 0;  j < g; j++) {
                for (int k = 0; k < b; k++) {
                    bw.write(i + " " + j + " " + k+"\n");
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

}

