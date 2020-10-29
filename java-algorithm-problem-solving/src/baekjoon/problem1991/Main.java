package baekjoon.problem1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1991 트리 순회 수
 * 
 * @author iamdawoonjeong
 * @reference https://www.acmicpc.net/problem/1991
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int n = Integer.parseInt(br.readLine()); //노드 갯수 
        
        // 트리생성
        Tree tree = new Tree(); 

        // 각 node에  값 넣어주기
        char ch[];
        for (int i = 0; i < n; i++) {
            ch = br.readLine().replaceAll(" ", "").toCharArray(); //value 나누기 
            tree.add(ch[0], ch[1], ch[2]); // 입력받은 value를 tree에 add (root, left, right) 
        } 
        
        // 순회하기 
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        
        br.close();
        isr.close();
    }

}

/**
 * 노드클래스
 *
 */
class Node{

    public char data;
    public Node left;
    public Node right;
    
    public Node(char input) {
        this.data = input;
    }
}

class Tree{
    Node root;
    public void add(char data, char left, char right) {
        
        // root가 비었을 경우
        if (null == root) {
            
            // 자식이 없는 경우를 제외하고 각 노드에 값 넣어주어 root 만들기 
            if('.' != data ) {
                root = new Node(data);
            }
            if ('.' != left) {
                root.left = new Node(left);
            }
            if ( '.' != right) {
                root.right = new Node(right);
            }
        }else {
            
            // root 가 있을 경우 
            search(root, data, left, right);
        }
    }
    
    public void search(Node root, char data, char left, char right) {
        
        // root 가 비었을 경우 
        if(null == root) {
            return;
        }else if(root.data == data) {
            
            //입력된 데이터가 부모데이터일 경우 자식노드 값 넣어주기
            if ('.' != left) {
                root.left = new Node(left);
            }
            if('.' != right) {
                root.right = new Node(right);
            }
        }else {
            
            // 입력된 데이터가 root가 아닌 자식 노드에 있을 경우 재귀함수를 이용하여 부모위치 찾기
            search(root.left, data, left, right);
            search(root.right, data, left, right);
        }
        
    }
    
    /**
     * 전위 순회
     * @param root
     */
    public void preorder(Node root) {
        
        System.out.print(root.data);
        
        if (null != root.left) {
            preorder(root.left);
        } 
        
        if (null != root.right) {
            preorder(root.right);
        }
    }
    
    /**
     * 중위 순회
     * @param root
     */
    public void inorder(Node root) {
        
        if (null != root.left) {
            inorder(root.left);
        } 
        
        System.out.print(root.data);
        
        if (null != root.right) {
            inorder(root.right);
        }
    }
    
    /**
     * 후위 순회
     * @param root
     */
    public void postorder(Node root) {
        
        if (null != root.left) {
            postorder(root.left);
        } 
        
        if (null != root.right) {
            postorder(root.right);
        }
        
        System.out.print(root.data);
    }
}