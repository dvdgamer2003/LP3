import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

public class Huffman {

    static void printCodes(Node root, String code) {

        if (root == null)
            return;

        // Leaf node means character found
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        // Left = 0
        printCodes(root.left, code + "0");

        // Right = 1
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String str = sc.nextLine();

        int[] freq = new int[256];

        // Count character frequencies
        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        // Min Priority Queue
        PriorityQueue<Node> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.freq, b.freq)
            );

        // Create leaf nodes
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                pq.add(new Node((char)i, freq[i]));
            }
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(
                '\0', left.freq + right.freq
            );

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        // Print Huffman Codes
        System.out.println("Huffman Codes:");

        if (!pq.isEmpty()) {
            Node root = pq.poll();

            if (root.left == null && root.right == null)
                System.out.println(root.ch + " : 0");
            else
                printCodes(root, "");
        }

        sc.close();
    }
}


//Time Complexity

/*"The overall time complexity of Huffman Coding is O(n + k log k), where n is the total number of characters and k is the number of distinct characters."

Space Complexity

"The space complexity is O(k), because we store k distinct characters in the priority queue and Huffman tree."*/