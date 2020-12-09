package hash.chainning;

import java.util.ArrayList;

public class HashTableChanning {
    
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.add("this",1 ); 
        hash.add("coder",2 ); 
        hash.add("this",4 ); 
        hash.add("hi",5 ); 
        
        
        System.out.println("getSize : "  + hash.getSize()); 
        System.out.println("get (this) : " + hash.get("this"));
        System.out.println("get (coder) : " + hash.get("coder"));
        System.out.println("get (hi) : " + hash.get("hi"));
        
        System.out.println("remove : "  + hash.remove("this")); 
        System.out.println("remove : "  + hash.remove("this")); 
        System.out.println("getSize : "  + hash.getSize());
        
        System.out.println("isEmpty : "  + hash.isEmpty()); 
        
    }
}

/**
 * Class to represent entire hash table 
 * @param <K>
 * @param <V>
 */
class HashMap<K, V>{
    ArrayList<HashNode<K,V>> bucket = new ArrayList<>();
    private int num;
    private int size;
    
    //Constructor
    public HashMap() {
        num = 10;
        size = 0;
        
        // Create empty chains 
        for (int i = 0; i < num; i++) {
            bucket.add(null);
            
        }
    }
    
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % num; 
        return index;
    }
    
    // Returns value for a key
    public V get(K key) {
        
        // Find head of chain for given key 
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        
        // Search for key in its chain 
        while(head != null) {
            if (head.key.equals(key)) {
                return head.value; 
            }
            head = head.next;
        }
        
        // If key not found 
        return null;
    }
    
    // Method to remove a given key 
    public V remove(K key) {
        int index = getBucketIndex(key);
        
        // Apply hash function to find index for given key 
        HashNode<K, V> head = bucket.get(index);
        HashNode<K, V> prev = null;
        
        // Search for key in its chain 
        while (head != null) {
            
            // If Key found 
            if (head.key.equals(key)) {
                break;
            }
            
            // Else keep moving in chain 
            prev=head;
            head=head.next;
        }
        
        if(head == null) {
            return null;
        }
        
        size--;

        if (prev != null) {
            prev.next = head.next;
        }else {
            bucket.set(index, head.next); 
        }
        return head.value; 
    }
    
    public void add(K key, V value) {
        
        // Find head of chain for given key 
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        
        // Check if key is already present 
        while ( head != null) {
            if ( head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        // Insert key in chain 
        size++;
        head = bucket.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucket.set(index, newNode);
        
        // If load factor goes beyond threshold, then double hash table size 
        if ((1.0*size)/num >= 0.7) {
            ArrayList<HashNode<K,V>> temp = bucket;
            bucket = new ArrayList<>();
            num = 2*num;
            size = 0 ;
            for (int i = 0; i < num; i++) {
                bucket.add(null);
            }
            
            for (HashNode<K, V> hashNode : temp) {
                while ( hashNode != null) {
                    add(hashNode.key, hashNode.value);
                    hashNode = hashNode.next;
                }
            }
        }
        
    }

}

/**
 * node of chains
 *
 * @param <K>
 * @param <V>
 */
class HashNode<K, V>{
    K key;
    V value;
    HashNode<K, V> next;
    
    public HashNode(K key, V value)  {
        this.key = key;
        this.value = value;
    }
}
