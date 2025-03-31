// Problem Statement: Implement a Trie data structure that supports the following methods:

// Insert (word): To insert a string `word` in the Trie.
// Count Words Equal To (word): Return the count of occurrences of the string word in the Trie.
// Count Words Starting With (prefix): Return the count of words in the Trie that have the string “prefix” as a prefix.
// Erase (word): Delete one occurrence of the string word from the Trie.

class Node {
    Node[] links;
    int cntPrefix;
    int cntEndWith;

    Node() {
        links = new Node[26];
        cntPrefix = 0;
        cntEndWith = 0;
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void increaseEndWith() {
        cntEndWith++;
    }

    void increasePrefix() {
        cntPrefix++;
    }

    void deleteEnd() {
        cntEndWith--;
    }

    void reducePrefix() {
        cntPrefix--;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEndWith();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.cntEndWith;
    }

    public int countWordsStartingWith(String word) {  // Fixed method signature
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.cntPrefix;  // Moved return statement outside loop
    }

    public void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix(); // Fixed method name
            } else {
                return;
            }
        }
        node.deleteEnd();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Inserting strings 'apple', 'app' into Trie");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'app' from trie");
        trie.erase("app");
        System.out.print("Count Words Equal to 'apple': ");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.print("Count Words Starting With 'app': ");
        System.out.println(trie.countWordsStartingWith("app"));
    }
}
