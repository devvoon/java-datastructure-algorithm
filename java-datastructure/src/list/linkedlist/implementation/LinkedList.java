package list.linkedlist.implementation;

public class LinkedList {
    
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{
        private Object data;
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    /**
     * 첫번째 노드 추가
     * 1. newNode.data를 셋팅
     * 2. newNode.next를 head가 현재 참조하는 값으로 가지고 오고
     * 3. head는 newNode를 참조하도록 함 (첫번째 노드이기 때문)
     * @param input
     */
    public void addFirst(Object input) {
        //입력된 값으로 새로운 노드 생성
        Node newNode = new Node(input);
        //첫번째 노드이기 때문에 생성된 새로운 노드의 next값은 기존에 head가 참조하고 있던 값을 가지고 됨(현 head의 next값은 구 head의 참조값을 가지게됨 )
        //최초 생성 노드라면 null 임 
        newNode.next = head;
        //head가 가지는 값은 newNode값을 참조하게 됨 
        head = newNode;
        //노드 사이즈 증가
        size++;
        
        //head.next 값이 없다면(최초의 노드 생성일 경우) tail에 head가 참조하는 값을 넣어줌
        if(head.next == null ) {
            tail = head;
        }
    }

    /**
     * 마지막 노드 추가
     * 1. newNode.data 셋팅
     * 2. tail.next를 기존 tail이 참조하고 있던(가르키고 있던) node의 next값이 newNode를 참조하게 함(구 tail이 가르키던 node의 next값이 생기게 됨)
     * 3. tail은 newNode를 참조
     * @param input
     */
    public void addLast(Object input) {
        //입력된 값으로 새로운 노드 생성
        Node newNode = new Node(input);
        
       //노드가 한 개도 없었다면
        if(size == 0) {
            //addFirst 를 타게 됨
            addFirst(input);
        } else {
            // 노드가 1개 이상인경우 
            //tail.next가 참조하고 있던 node는 newNode를 가르키게 됨(구 tail이 참조하던 노드의 next값은 현 tail이 될 newNode를 가리키게 됨)
            tail.next = newNode;
            //tail은 noeNode값을 참조하게 됨 
            tail = newNode;
            //노드 사이즈 증가
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
        //head 가 참조하는 값을 x가 가짐
        Node x = head;
        //index까지 x의 next를 가지게 됨
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    /**
     * index k 에 input 값 추가
     * (k-1) -> (k) -> (k+1)
     * @param k
     * @param input
     */
    public void add(int k, Object input) {
        // 첫번째 인덱스이면 addFirst 호출
        if( k == 0) {
            addFirst(input);
        } else {
            //k의 이전 node는 temp에 담기 
            Node temp1 = node(k-1);
            //k의 이전노드가 가르키는 node는 temp2에 담기
            Node temp2 = temp1.next;
            //새로운 노드 생성 
            Node newNode = new Node(input);
            
            //k의 이전node가 가르키는 값은 newNode로 지정
            temp1.next = newNode;
            //newNode.netx 값은 k의 이전노드가 가리켰던 node 참조하게 됨
            newNode.next = temp2;
            
            //사이즈 증가 
            size++;
            
            // newNode.next 가 가르키는 값이 null이라면 newNode는 tail임으로 tail일이 가르키는 값은 newNode로 
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }
    
    /**
     * print LinkedList Elements
     */
    public String toString() {
        
        if(head == null ) {
            return "[]";
        }
        
        Node temp = head;
        String str = "[";
        
        //head부터 next가 not null 일때까지 data 의 값을 계속 str에 저장
        while(temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        
        //마지막 node의 data를 가지고오는것은 위의 while문으로 안되므로 아래와 같이 가지고옴
        str = str + temp.data;
        
        return str+"]";
    }

    /**
     * 첫번째 노드 삭제
     */
    public Object removeFirst() {
        Node temp = head;
        //head가 다음 노드로 가르키는 값으로 head를 대체 
        head = head.next;
        //삭제할 head의 값 담기 
        Object returnData = temp.data;
        temp = null;
        //사이즈 감소
        size--;
        return returnData;
    }

    /**
     * remove node 
     * @param k
     * @return
     */
    public Object remove(int k) {
        if( k == 0) {
            return removeFirst();
        }
        
        //삭제할 k-1의 노드를 temp가 가지고 있기 
        Node temp = node(k-1);
        //삭제될 노드는 담기
        Node todoDeleted = temp.next;
        //temp.next값은 결국 temp의 next next의 값이 됨 
        temp.next = temp.next.next;
        Object returnData = todoDeleted.data;
        
        //삭제될 노드가 tail였다면 k-1노드가 tail이 됨 
        if ( todoDeleted == tail) {
            tail = temp;
        }
        
        todoDeleted = null;
        size--;
        
        return returnData; 
    }

    /**
     * 마지막 node 삭제
     * @return
     */
    public Object removeLast() {
        //마지막 노드의 index = size-1;
        return remove(size-1);
    }

    /**
     * linked list 사이즈값 구하기 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * index k 번째 data 구하기
     * @param k
     * @return
     */
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    /**
     * data 가 존재하는 index 구하기 
     * 없으면 -1 return
     * @param data
     * @return
     */
    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while (temp.data != data) {
            temp =temp.next;
            index++;
            if (temp == null) {
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
     * ListIterator (inner class)
     */
    class ListIterator{
        private Node next;
        private Node lastReturned;
        private int nextIndex;
        
        /**
         *ListIterator가 생성되었을때 초기화 
         */
        ListIterator(){
            next = head;
        }
        
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned; 
        }

        public boolean hasNext() {
            
            return nextIndex < size();
        }
        
        public void add(Object input) {
            Node newNode = new Node(input);
            
            if(lastReturned == null ) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {

            if(nextIndex == 0) {
                throw new IllegalStateException();
            }

            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
    
}
