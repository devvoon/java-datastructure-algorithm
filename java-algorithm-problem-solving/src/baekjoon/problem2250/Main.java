package baekjoon.problem2250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2250 트리의 높이와 너비
 * 
 * @references https://www.acmicpc.net/problem/2250
 * @author iamdawoonjeong
 */
public class Main {
    
    public static Node[] tree;
    public static int[] widthMin;
    public static int[] widthMax;

    public static int levelDepth;
    public static int nodeIndex = 1;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());  // 노드의 갯수 
        tree = new Node[n+1]; //노드의 갯수만큼 트리 만들기 
        widthMin = new int [n+1]; // 최소레벨
        widthMax = new int [n+1]; // 최대레벨
        int root = -1;

        // 노드를 각각 만들어줌
        for (int i = 1; i < n+1; i++) {
            tree[i] = new Node(i, -1, -1, -1);
            widthMin[i] = n;
            widthMax[i] = 0;
        }
        
        for (int i = 1; i < n+1; i++) {
           st = new StringTokenizer(br.readLine());
           int data = Integer.parseInt(st.nextToken());
           int left = Integer.parseInt(st.nextToken());
           int right = Integer.parseInt(st.nextToken());
           
           //입력되 왼쪽, 오른쪽데이터값 저장
           tree[data].left = left;
           tree[data].right = right;
           
           //left 노드값이 있다면, left노드의 부모값을 현재 노드 값으로 입력 
           if( left != -1) {
               tree[left].parent = data;
           }
           
           //right 노드값이 있다면, right노드의 부모값을 현재 노드의 값으로 입력
           if ( right != -1) {
               tree[right].parent = data;
           }
        }
        
        //최상의 노드 찾기
        for(int i = 1; i <= n; i++) {
            //현노드의 부모가 없는 경우 = -1인경우
            if(tree[i].parent == -1) {
                //루트임
                root = i;
            }
        }
        
        //루트 1레벨부터 출발
        dfs(root, 1);
        
        int resultLevel = 1;
        int resultWidth = widthMax[1] - widthMin[1] + 1;
        
        
        for (int i = 2; i <= levelDepth; i++) {
            int width = widthMax[i] - widthMin[i] +1;
            
            if (resultWidth < width) {
                resultLevel = i;
                resultWidth = width;
            }
        }
        
        System.out.println(resultLevel + " " + resultWidth);
        
        br.close();

    }
    
    /**
     * dfs
     * @param data
     * @param level
     */
    public static void dfs(int data, int level) {
        
        Node node = tree[data];
        
        levelDepth = Math.max(levelDepth, level);
        
        //중위순회 
        if (node.left != -1) {
            dfs(node.left, level+1);
        }
        
        widthMin[level] = Math.min(widthMin[level], nodeIndex);
        widthMax[level] =  Math.max(widthMax[level], nodeIndex);
        nodeIndex++;
        
        if(node.right != -1) {
            dfs(node.right, level+1);
        }
    }

}

/**
 * node class
 */
class Node{
    public int data;
    public int parent;
    public int left;
    public int right;
    
    public Node(int input, int left, int right, int parent) {
        this.data = input;
        this.parent = -1;
        this.left = left;
        this.right = right;
    }
}
