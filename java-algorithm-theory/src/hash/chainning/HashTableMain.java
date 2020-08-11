package hash.chainning;

public class HashTableMain {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(3);
		hashTable.put("jeong", "this is my given name");
		hashTable.put("dawoon", "this is my name");
		
		System.out.println(hashTable.get("jeong"));
		System.out.println(hashTable.get("dawoon"));
		System.out.println(hashTable.get("you"));
	}
}
