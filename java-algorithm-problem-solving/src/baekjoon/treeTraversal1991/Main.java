package baekjoon.treeTraversal1991;

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
        
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        char ch[];
        for (int i = 0; i < n; i++) {
            ch = br.readLine().replaceAll(" ", "").toCharArray();
            tree.add(ch[0], ch[1], ch[2]);
        } 
        
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        
        br.close();
        isr.close();
    }

}

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
    public void add(char input, char left, char right) {
        
        if (null == root) {
            if('.' != input ) {
                root = new Node(input);
            }
            if ('.' != left) {
                root.left = new Node(left);
            }
            if ( '.' != right) {
                root.right = new Node(right);
            }
        }else {
            search(root, input, left, right);
        }
    }
    
    public void search(Node root, char input, char left, char right) {
        if(null == root) {
            return;
        }else if(root.data == input) {
            if ('.' != left) {
                root.left = new Node(left);
            }
            if('.' != right) {
                root.right = new Node(right);
            }
        }else {
            search(root.left, input, left, right);
            search(root.right, input, left, right);
        }
        
    }
    
    public void preorder(Node root) {
        
        System.out.print(root.data);
        
        if (null != root.left) {
            preorder(root.left);
        } 
        
        if (null != root.right) {
            preorder(root.right);
        }
    }
    
    public void inorder(Node root) {
        
        if (null != root.left) {
            inorder(root.left);
        } 
        
        System.out.print(root.data);
        
        if (null != root.right) {
            inorder(root.right);
        }
    }
    
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