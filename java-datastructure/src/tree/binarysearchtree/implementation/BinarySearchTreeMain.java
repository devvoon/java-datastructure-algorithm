package tree.binarysearchtree.implementation;

/**
 * BinarySearchTree 구현
 * @author iamdawoonjeong
 *
 */
public class BinarySearchTreeMain {

    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(20);
        bst.add(15);
        bst.add(30);
        bst.add(18);
        bst.add(25);
        bst.add(22);
        bst.add(40);
        bst.add(50);
        
        //find root
        System.out.println("find root of Binary search tree : ");  
        System.out.println(bst.root.data);
        
        System.out.println("Binary search tree after insertion :");  
        //Displays the binary tree  
        bst.inorderTraversal(bst.root);  
        
        bst.delete(bst.root, 30);
        //Displays the binary tree  
        System.out.println("\nBinary search tree after deleting node 30 :");
        bst.inorderTraversal(bst.root);
        
        
        bst.delete(bst.root, 50);
        //Displays the binary tree  
        System.out.println("\nBinary search tree after deleting node 50 :");
        bst.inorderTraversal(bst.root);  
    }

}
