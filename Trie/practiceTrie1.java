class Node{
	Node[] links = new Node[26];
	boolean flag = false;

	public boolean containsKey(char ch){
		return links[ch - 'a'] != null;
	}

	void put(char ch, Node node){
		link[ch - 'a'] =  node()
	}

	Node get(char ch){
		return links[ch - 'a'];
	}

	void setFlag(){
		flag = true;
	}

	boolean isEnd(){
		return flag;
	}

}

class Trie{
	static Node root;

	Trie(){
		root = new Node();
	}

	public void insert(String word){
		Node node = root;
		for(int i = 0; i < word.length(); i++){
			if(!node.containsKey(word.charAt(i))){
				node.put(word.charAt(i), new Node())
			}
			node = node.get(word.charAt(i))
		}
		node.setFlag();
	}

	// existance of the word in the trie

	public boolean search(Strin word){
		Node node = root;
		for(int i =0; i< word.length(); i++){
			if(!node.containsKey(word.charAt(i))){
				return false;
			}
			node = node.get(word.charAt(i));
		}
		
		return node.isEnd();
	}

	public boolean startsWith(String prefix){
		Node node = root;
		for(int i = 0; i< prefix.length; i++){
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