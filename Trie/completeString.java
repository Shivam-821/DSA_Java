// Longest string with all prefixes

import java.util.*;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int j = 0; j < word.length(); j++) {
            if (!node.containsKey(word.charAt(j))) {
                node.put(word.charAt(j), new Node());
            }
            node = node.get(word.charAt(j));
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExist(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if (!node.isEnd()) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public static String completeString(int n, String[] a) {
        Trie t = new Trie();

        // Insert the string one by one into the trie
        for (int i = 0; i < n; i++) {
            t.insert(a[i]);
        }

        String largest = "";
        for (int i = 0; i < n; i++) {
            if (t.checkIfPrefixExist(a[i])) {
                if (a[i].length() > largest.length() || 
                    (a[i].length() == largest.length() && a[i].compareTo(largest) < 0)) {
                    largest = a[i];
                }
            }
        }

        return largest.equals("") ? "None" : largest;
    }

    public static void main(String[] args) {
        String[] a = {"a", "app", "ap", "apply", "apple"};
        int n = a.length;
        System.out.println(completeString(n, a)); 
    }
}
