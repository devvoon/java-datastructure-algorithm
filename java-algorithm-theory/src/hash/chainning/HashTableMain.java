package hash.chainning;

/**
 * Hash Chain 구현 
 * @author iamdawoonjeong
 * @references https://youtu.be/Vi0hauJemxA
 */
public class HashTableMain {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        hashTable.put("hashtable", "a data structure that implements an associative array abstract data type");
        hashTable.put("hashfunction", "takes an input as a key");
        
        System.out.println(hashTable.get("hashtable"));
        System.out.println(hashTable.get("hashfunction"));
        System.out.println(hashTable.get("hash"));
    }
}
