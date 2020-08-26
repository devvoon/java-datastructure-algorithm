package tree.binarysearchtree.implementation;

/**
 * BinarySearchTree 구현
 * @author iamdawoonjeong
 *
 */
public class BinarySearchTreeMain {

    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        //insert
        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);
        bst.add(10);
        bst.add(90);

        //Displays the binary tree
        System.out.println("Binary search tree after insertion :");  

        System.out.println("Inorder Traversal :");
        bst.inorderTraversal(bst.root);
        System.out.println();
        
        System.out.println();
        System.out.println("Preorder Traversal :");
        bst.preorderTraversal(bst.root);
        System.out.println();
        
        System.out.println();
        System.out.println("Postorder Traversal :");
        bst.postorderTraversal(bst.root);
        System.out.println();
        
        //search
        System.out.println();
        System.out.println("Search element :");
        bst.searchRecursion(bst.root, 10);
        bst.searchRecursion(bst.root, 15);
        bst.search(bst.root, 80);
        bst.search(bst.root, 85);
        
        //사이즈 구하기
        System.out.println();
        System.out.println("Get size of  Binary search tree : ");
        System.out.println(bst.size);

        //search
        System.out.println();
        System.out.println("Find root of Binary search tree : ");  
        System.out.println(bst.root.data);

        //delete
        System.out.println();
        bst.delete(bst.root, 30);
        System.out.println("Binary search tree after deleting node 30 :");
        bst.inorderTraversal(bst.root);
        System.out.println();
        
        //delete
        bst.delete(bst.root, 60);
        System.out.println();
        System.out.println("Binary search tree after deleting node 60 : " );
        bst.inorderTraversal(bst.root);
        System.out.println();
        
        //사이즈 구하기
        System.out.println();
        System.out.println("Get size of  Binary search tree : ");
        System.out.println(bst.size);
        
    }

}
