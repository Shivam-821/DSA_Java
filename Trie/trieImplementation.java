// Problem Statement: Implement a Trie Data Structure which supports the following three operations:

// Search (word): To check if the string `word` is present in the Trie or not.
// Insert (word): To insert a string `word` in the Trie.
// Start With(word): To check if there is a string that has the prefix `word`.

class Node{
	Node[] links = new Node[26];
	boolean flag = false;

	public boolean containsKey(char val){
		return links[val - 'a'] != null;
	}

	void put(char ch, Node node){
		links[ch - 'a'] = node;
	}

	void setEnd(){
		flag = true;
	}

	Node get(char ch){
		return links[ch - 'a'];
	}

	boolean isEnd(){
		return flag;
	}

}

class Trie{

	private static Node root;

	// constructor
	Trie(){
		root = new Node();
	}

	public void insert(String word){
		Node node = root;
		for(int i = 0; i < word.length(); i++){
			if(!node.containsKey(word.charAt(i))){
				// create a new Node for the letter if not present
				node.put(word.charAt(i), new Node());
			}
			// Move to the next node
			node = node.get(word.charAt(i));
		}
		node.setEnd();
	}

	// return true if the word is in the trie
	public boolean search(String word){
		Node node = root;
		for(int i = 0; i < word.length(); i++){
			if(!node.containsKey(word.charAt(i))){
				return false;
			}
			// Move to the next node
			node = node.get(word.charAt(i));
		}

		return node.isEnd();
	}

	public boolean startsWith(String prefix){
		Node node = root;
		for(int i =0; i<prefix.length(); i++){
			if(!node.containsKey(prefix.charAt(i))){
				return false;
			}
			node = node.get(prefix.charAt(i));
		}
		return true;
	}

	public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("strike");

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
    }
}