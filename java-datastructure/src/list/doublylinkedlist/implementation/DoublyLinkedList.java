package list.doublylinkedlist.implementation;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;
    
    private class Node{
        private Object data;
        private Node prev;
        private Node next;
        
        public Node(Object input) {
            this.data = input;
            this.prev = null;
            this.next = null;
        }
        
        public String toString() {
            return String.valueOf(this.data);
        }
    }
    
    /**
     * 첫번째 노드 추가
     * @param input
     */
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        if (head !=null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }
     
    public  void addLast(Object input) {
        Node newNode = new Node(input);
        
        if ( size == 0 ) {
            addFirst(input);
        }else {
            tail.next = newNode;
            newNode.prev = tail; 
            tail = newNode;
            size++;
        }
    }
    
    /**
     * Node API (내부적으로만 사용)
     * Index에 해당하는 값 return
     * @param index
     * @return
     */
    Node node(int index) {
        // prev, head 가 있기 때문에 이를 활용해서 효율적으로 index 찾을수 있음

        //찾고자하는 인덱스가 size/2 보다 작으면 head부터 증가하면서 순차 탐색
        if (index  < size/2 ) {
             Node x = head;
             
             // x.next로 index 노드의 값을 갖게 됨 
             for (int i = 0; i < index; i++) {
                 x = x.next;
             }
             return x;
             
        }else {
        // 찾고자 하는 인덱스가 size/2 보다 크면 tail 부터 감소하면서 순차 탐색
             Node x = tail;
             for (int i = size-1 ; i > index ; i--) {
                 x = x.prev;
             }
             return x;
        }
     
    }
    
    /**
     * 원하는 위치 k에 새로운 노드 추가
     * @param k
     * @param input
     */
    public void add(int k, Object input) {
        //k가 fisrt 일때 
        if (k==0) {
            addFirst(input);
        }else {
            //(k-1), k , (k+1)
            Node temp1 = node(k-1);
            Node temp2 = temp1.next;
            
            //새로운 노드생성
            Node newNode = new Node(input);
            //k-1의 next는 newNode가 됨
            temp1.next = newNode;
            //newNode.next는 temp1.next가 됨
            newNode.next = temp2;
            
            //temp2==null이며, temp1이 tail임
            if ( temp2 != null) {
                 temp2.prev = newNode;
            }
            newNode.prev = temp1;
            
            size++;
            
            //temp2==null이며, temp1이 tail이였던 것
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }
    
    /**
     * print DoublyLinkedList Elements
     */
    public String toString() {
        if(head == null) {
           return "[]";
        }
        
        Node temp = head;
        String str  = "[";
        
        while(temp.next != null) {
            str+=temp.data + ", ";
            temp=temp.next;
        }
        
        str = str + temp.data;
        return str +"]";
    }
    
    /**
     * remove the first node
     * @return
     */
    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return returnData;
    }
    
    /**
     * remove a node
     * @return
     */
    public Object remove(int k) {
        if ( k == 0 ) {
            return removeFirst();
        }
        
        Node temp = node(k-1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        if (temp.next != null) {
            temp.next.prev = temp;
        }
        
        Object returnedData = todoDeleted.data;
        
        if ( todoDeleted == tail) {
            tail = temp;
        }
        
        todoDeleted = null;
        
        size--;
        
        return returnedData;
    }
    
    /**
     * remove of the last node
     * @return
     */
    public Object removeLast() {
        return remove(size-1);
    }
    
    /**
     * get size of doubly linked list 
     * @return
     */
    public int size() {
        return size; 
    }
    
    /**
     * get data of index k 
     * @param k
     * @return
     */
    public Object get(int k) {
         Node temp = node(k);
         return temp.data;
    }
    

    /**
     * get index if data exist or not return -1
     * @param data
     * @return
     */
    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while (temp.data  != data) {
            temp = temp.next;
            index++;
            if (temp==null) {
                return -1;
            }
        }
        
      return index;
    }
    
    /**
     * ListIterator을 인스턴스화 해서 리턴
     */
    public ListIterator listIterator() {
        return new ListIterator();
    }
    
    /**
     *  ListIterator (inner class)
     */
    class ListIterator{
        private Node next;
        private Node lastReturned;
        private int nextIndex;
        
        /**
         *ListIterator가 생성되었을때 초기화 
         * next는 head를 가리키고 있음
         */
        ListIterator(){
            next = head;
            nextIndex=0;
        }
        
        /**
         * next가 가르키는 값 구하고 next는 증가시키기
         * @return
         */
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            
            return lastReturned.data;
        }
        
        public Object previous() {
            //탐색이 끝난 상태
            if (next == null ) {
                lastReturned = next = tail;
            } else {
                lastReturned = next = next.prev;
            }
            
            nextIndex--;
            return lastReturned.data;
        }
        
        /**
         * nextIndex가 존재하면 true , 존재하지않으면 false
         * @return
         */
        public boolean hasNext() {
            return nextIndex < size();
        }
        
        /**
         * nextIndex가 0보다 크면 true, 그렇지 않으면 false
         * @return
         */
        public boolean hasPrevious() {
            return nextIndex > 0 ;
        }
        
        public void add(Object input) {
            Node newNode = new Node(input);
            
            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if (next != null ) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
                }
            }
            
            lastReturned = newNode;
            nextIndex++;
            size++;
        }
        
        public void remove() {
            if (nextIndex == 0 ) {
                throw new IllegalStateException();
            }
            
            //lastReturned가 가르키고 있는 노드 삭제 
            Node n = lastReturned.next;
            Node p = lastReturned.prev;
            
            if (p==null) {
                head = n;
                head.prev = null;
                lastReturned = null;
            }else {
                p.next = next;
                lastReturned.prev = null;
            }
            
            if (n  == null) {
                tail = p;
                tail.next = null;
            }else {
                n.prev = p;
            }
            
            if (next == null) {
                lastReturned = tail;
            }else {
                lastReturned = next.prev;
            }
            
            size--;
            nextIndex--;
        }
    }

}
