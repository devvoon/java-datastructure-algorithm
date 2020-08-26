package tree.binarysearchtree.implementation;

/**
 * BST
 * root는 미리 지정(Binary Search의 특징상)
 * 한 Node당 data, left node, right node가 필요
 */
public class BinarySearchTree {
    
    public Node root;
    public int size = 0;
    
    //node class
    public class Node{
        public int data;
        public Node left;
        public Node right;
    
        public Node(int input) {
            //new node 생성시 데이터를할당하고, 왼쪽 오른쪽 노드는 모두 null  
            this.data = input;
            this.left = null;
            this.right = null;
        }
        
        public String toString() {
            return String.valueOf(this.data);
        }
    }
    
    //초기화 root노드는 null
    public BinarySearchTree() {
        root = null;
    }
    
    /**
     * 새로운 노드 추가
     * 1. 부모의 값보다 작은 원소는 왼쪽, 큰 원소는 오른쪽 하위 트리
     * 2. root node의 data와 비교를 시작해서 비교해서 내려감
     * 3. node가 빌 때까지 반복한 후 데이터 넣고 종료
     * @param input
     */
    public void add(int input) {
        //입력된 값으로 노드 생성
        Node newNode = new Node(input);
        
        //트리가 비었는지 여부 체크
        if(null == root) {
            //비었으면 newNode가 root가 됨
            root = newNode;
            size++;
            return ;
        }else {
            // root를 current(비교대상노드)로 지정. 
            // root의 data부터 input값과 제일먼저 비교 
            Node current = root;
            Node parent = null;
            
            while (true) {
                //parent는 current node의 상위 노드를 추적 하는데 사용함
                parent = current;
                
                //입력된 데이터의 값이 현재 비교대상인 current 노드의 data보다 작을 경우, 
                if(input < current.data) {
                   //current.left노드를 비교대상으로 올려서
                    current = current.left;
                    if (null == current) {
                       //current 노드의 값이 null 이 되었을 경우 그제서야 left에 new node 삽입
                        parent.left = newNode;
                        //데이터가 삽입되면 종료됨
                        size++;
                        return;
                    }
                }else {
                    //입력된 데이터의 값이 현재 비교대상인 current 노드의 data보다 작을 경우, 
                    //current.right 노드를 비교대상으로 올림
                    current = current.right;
                    //올렸는데 current가 비어있으면
                    if (null == current) {
                        //오른쪽으로 삽입
                        parent.right = newNode;
                        //데이터가 삽입되면 종료됨
                        size++;
                        return;
                    }
                }
            }
        }
    }
    
    /**
     * 최소 노드 찾기
     * @param root
     * @return
     */
    public Node minNode(Node root) {
        //루트의 왼쪽 노드가 null이 아닐 때까지 순환
        if ( null != root.left ) {
            return minNode(root.left);
        }else {
            return root;
        }
    }
    
    /**
     * 노드 삭제
     * 1. 삭제 대상 노드의 child node 가 없는 경우 : 바로 삭제. parent node null 처리  
     * 2. 삭제 대상 노드의 right child node만 있는 경우 : right child node를  삭제될 위치로 올려주기(parent node.right가 가르키도록)
     * 3. 삭제 대상 노드의 left child node만 있는 경우 : left child node 를 삭제될 위치 올려주기(parent node.left에 넣어주기)
     * 4. 삭제 대상 노드의 right, left child node 모두 있는 경우 : right child node가 큰 쪽 이므로, right child node들 중 에 제일 작은 node 를 삭제될 위치로 올려주기(parent node.right가 가르키도록)
     * @param node
     * @param input
     * @return
     */
    public Node delete(Node node, int input) {
        
        if (null == node) {
            return null;
        }else {
            //삭제 탐색의 시작은 root 노드 부터
            //삭제대상의 값이 node의 값보다작으면 노드의 왼쪽 순환 탐색
            if (input < node.data) {
                node.left = delete(node.left, input);
                
            //삭제대상의 값이 node의 값보다 크면 노드의 오른쪽으로 순환 탐색
            }else if (input > node.data) {
                node.right = delete(node.right, input);
             
            //만약 같은 값의 노드를 만났다면 삭제대상임  
            }else {
                //삭제 대상의 오른쪽, 왼쪽 양쪽모두 자식노드가 없을 경우
                if (null == node.left &&  null == node.right) {
                   //노드는 바로 삭제 됨 
                    node = null;
                    size--;
                    
                // 오른쪽에만 자식 노드가 있다면 
                }else if (null == node.left) {
                    //오른쪽 자식노드값을 삭제될 위치로 올려줌
                    node = node.right;
                    size--;
                    
                // 왼쪽에만 자식 노드가 있다면
                }else if (null == node.right) {
                    //왼쪽 자식노드의 값을 삭제될 위치로 올려줌
                    node = node.left;
                    size--;
                    
                //오른쪽, 왼쪽 모두 자식노드가 있는 경우
                //오른쪽 하위 노드가 큼으로 
                }else {
                    //오른쪽 하위 트리의 최소노드 찾아 temp에 담기
                    Node temp = minNode(node.right);
                    //찾은 최소노드의 값을 node.data에 담아 올리고
                    node.data = temp.data;
                    //찾은 최소노드는 오른쪽 하위 트리에서 삭제노드로 선정해서 삭제됨(중복임) 순환
                    node.right = delete(node.right, temp.data);
                }
            }
        }
        return node;
    }
    
    /**
     * inorder traversal
     * Left -> Root -> Right
     * @param node
     */
    public void inorderTraversal(Node node) {
        //Check whether tree is empty  
        if ( null == root ) {
            System.out.println("Tree is empty");
            return;
        }else {
            if ( null != node.left) {
                inorderTraversal(node.left);
            }
            //Root는 왼쪽 서브 트리 다 순회 후
            System.out.print(node.data + " ");
            if (null != node.right ) {
                inorderTraversal(node.right);
            }
        }
    }
    
    /**
     * preorder traversal
     * Root -> Left -> Right
     * @param node
     */
    public void preorderTraversal(Node node) {
        //Check whether tree is empty  
        if ( null == root ) {
            System.out.println("Tree is empty");
            return;
        }else {
            //Root 먼저 읽고 순회 
            System.out.print(node.data + " ");
            if ( null != node.left )  {
                inorderTraversal(node.left);
            }
            if (null != node.right ) {
                inorderTraversal(node.right);
            }
        }
    }
    
    /**
     * postorder traversal
     * Left -> Right  ->  Root
     * @param node
     */
    public void postorderTraversal(Node node) {
        //Check whether tree is empty  
        if ( null == root ) {
            System.out.println("Tree is empty");
            return;
        }else {
            if ( null != node.left )  {
                inorderTraversal(node.left);
            }
            if (null != node.right ) {
                inorderTraversal(node.right);
            }
            //Root는 맨 마지막
            System.out.print(node.data + " ");
        }
    }
    
    /**
     * 반복문을 통한 search
     * @param node
     * @param input
     * @return
     */
    public boolean search(Node node, int input) {
        if ( null == root) {
            System.out.println("Tree is empty");
            return false;
        }else {
            Node current  = node;
            
            //current node의 left, right child가 모두 비었을 때까지 반복해서 찾기 (마지막 까지 반복)
            while(true){
                //찾는 데이터보다 current 값이 클 경우
                if (input < current.data) {
                    //left에 있는 자식 노드들을 탐색
                    current = current.left;
                    
                    //current가 null인 경우 탐색할 노드가 더이상 없다는 의미
                    if ( null == current) {
                        System.out.println("not found : " + input );
                        return false; 
                    }
                
                //찾는 데이터보다 current 데이터가 작을 경우
                }else if (input > current.data) {
                    //right에 있는 자식 노드들을 탐색
                    current = current.right;
                    
                    //current가 null인 경우 탐색할 노드가 더이상 없다는 의미
                    if ( null == current) {
                        System.out.println("not found : " + input );
                        return false; 
                    }
                    
                //찾는 데이터와 current 노드의 데이터가 같을 경우 
                }else if (input == current.data) {
                    //출력하면서 종료
                    System.out.println("finding using while: " + current.data);
                    return true;
                } 
            }
        }
    }
    
    /**
     * recursion을 이용한 search
     * @param node
     * @param input
     * @return
     */
    public boolean searchRecursion(Node node, int input) {
        if ( null == root) {
            System.out.println("Tree is empty");
            return false;
        }else {
            Node current  = node;
            if (input < current.data) {
                current = current.left;
                
                if (null == current) {
                    System.out.println("not found : " + input);
                    return false;
                }else {
                    return searchRecursion(current, input);
                }
                
            }else if (input > current.data) {
                current = current.right;
                
                if ( null == current) {
                    System.out.println( "not found : " + input);
                    return false;
                }else {
                    return searchRecursion(current, input);
                }
                
            }else if (input == current.data) {
                System.out.println("finding using recursion: " + current.data);
                return true;
            } 
        }
       return false;
    }
    
    /**
     * tree 사이즈 구하기
     * @return
     */
    public int size() {
        return size;
    }

}
