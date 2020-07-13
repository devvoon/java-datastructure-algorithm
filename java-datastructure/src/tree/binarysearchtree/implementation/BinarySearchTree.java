package tree.binarysearchtree.implementation;

public class BinarySearchTree {
	
    //Represent a node of binary tree  
	public static class Node{
		public int data;
		public Node left;
		public Node right;
	
		public Node(int input) {
            //Assign data to the new node, set left and right children to null  
			this.data = input;
			this.left = null;
			this.right = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void add(int input) {
		//Create a new node
		Node newNode = new Node(input);
		
		//check whether tree is empty
		if(null == root) {
			root = newNode;
			return ;
		}else {
			//current node point to root of the tree
			Node current = root;
			Node parent = null;
			
			while (true) {
				//parent keep track of the parent node of current node.  
				parent = current;
				
				//If data is less than current's data, node will be inserted to the left of tree
				if(input < current.data) {
					current = current.left;
					if (null == current) {
						parent.left = newNode;
						return;
					}
				}else {
					//If data is greater than current's data, node will be inserted to the right of tree  
					current = current.right;
					if (null == current) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
    //minNode() will find out the minimum node  
	public Node minNode(Node root) {
		if ( null != root.left ) {
			return minNode(root.left);
		}else {
			return root;
		}
	}
	
	//deleteNode() will delete the given node from the binary search tree  
	public Node delete(Node node, int input) {
		
		if (null == node) {
			return null;
		}else {
			//value is less than node's data then, search the value in left subtree  
			if (input < node.data) {
				node.left = delete(node.left, input);
				
		    //value is greater than node's data then, search the value in right subtree  
			}else if (input > node.data) {
				node.right = delete(node.right, input);
				
		    //If value is equal to node's data that is, we have found the node to be deleted  	
			}else {
				//If node to be deleted has no child then, set the node to null  
				if (null == node.left &&  null == node.right) {
					node = null;
					
			    //If node to be deleted has only one right child 			
				}else if (null == node.left) {
					node = node.right;
					
	            //If node to be deleted has only one left child  
				}else if (null == node.right) {
					node = node.left;
					
			    //If node to be deleted has two children node  
				}else {
					//then find the minimum node from right subtree  
					Node temp = minNode(node.right);
					//Exchange the data between node and temp  
					node.data = temp.data;
					//Delete the node duplicate node from right subtree  
					node.right = delete(node.right, temp.data);
				}
			}
			
		}
		return node;
	
	}

    //inorder() will perform inorder traversal on binary search tree  
	public void inorderTraversal(Node node) {
        //Check whether tree is empty  
		if (null == root ) {
			System.out.println("Tree is empty");
			return;
		}else {
			if ( null != node.left) {
				inorderTraversal(node.left);
			}
			System.out.print(node.data + " ");
			if (null != node.right ) {
				inorderTraversal(node.right);
			}
		}
		
	}


}
