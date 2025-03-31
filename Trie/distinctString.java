// Problem Statement: Implement a program that takes a string 'S' as input and returns the number of distinct substrings of the given
 // string, including the empty substring. Use a trie data structure to accomplish this.

class Node {
    Node[] links = new Node[26];

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    static int countDistinctSubstrings(String word) {
        int cnt = 0;

        for (int i = 0; i < word.length(); i++) {
            Node node = root;
            for (int j = i; j < word.length(); j++) {
                if (!node.containsKey(word.charAt(j))) {
                    cnt++;
                    node.put(word.charAt(j), new Node());  // Fixed syntax error
                }
                node = node.get(word.charAt(j));  // Fixed variable mismatch
            }
        }
        return cnt + 1; // +1 is for the empty string
    }

    public static void main(String[] args) {
        String s = "striver";

        System.out.println("Current String: " + s);
        System.out.println("Number of distinct substrings: " + countDistinctSubstrings(s));
    }
}
