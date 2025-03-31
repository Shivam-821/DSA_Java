import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {  
        this.ch = ch;
        this.freq = freq;
    }
}

class Huffman {

    static class CompareNode implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.freq - b.freq;
        }
    }

    public static Node buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new CompareNode());

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) { 
            Node left = pq.poll();
            Node right = pq.poll();
            Node merged = new Node('$', left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            pq.add(merged);
        }
        return pq.poll();
    }

    public static void generateCodes(Node root, String code, Map<Character, String> mp) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            mp.put(root.ch, code);
        }

        generateCodes(root.left, code + "0", mp);
        generateCodes(root.right, code + "1", mp);
    }

    public static String encode(String text, Map<Character, String> mp) {
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(mp.get(ch));
        }
        return encodedText.toString();
    }

    public static String decode(String encodedText, Node root) {
        StringBuilder decodeText = new StringBuilder();
        Node current = root;
        for (char bit : encodedText.toCharArray()) {
            current = (bit == '0') ? current.left : current.right; 

            if (current.left == null && current.right == null) {
                decodeText.append(current.ch);
                current = root;
            }
        }

        return decodeText.toString();
    }

    public static void main(String[] args) {
        String text = "hello";

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        Node root = buildHuffmanTree(freqMap);

        Map<Character, String> mp = new HashMap<>(); 
        generateCodes(root, "", mp);

        String encodedText = encode(text, mp);
        String decodedText = decode(encodedText, root);

        System.out.println("Text: " + text);
        System.out.println("Huffman Codes: " + mp);
        System.out.println("Encoded Text: " + encodedText);
        System.out.println("Decoded Text: " + decodedText);
    }
}
