### FIBOONACI







import java.util.Scanner;



class Fibonacci {



&#x20;   static int recursiveCount = 0;



&#x20;   // Recursive method

&#x20;   static int fib(int n) {



&#x20;       recursiveCount++;



&#x20;       if (n <= 1)

&#x20;           return n;



&#x20;       return fib(n - 1) + fib(n - 2);

&#x20;   }



&#x20;   // Non-recursive method

&#x20;   static int iterative(int n) {



&#x20;       int a = 0, b = 1, c;

&#x20;       int count = 0;



&#x20;       for (int i = 2; i <= n; i++) {



&#x20;           c = a + b;

&#x20;           a = b;

&#x20;           b = c;



&#x20;           count++;

&#x20;       }



&#x20;       System.out.println("Step Count (Non-Recursive): " + count);



&#x20;       return (n == 0) ? 0 : b;

&#x20;   }



&#x20;   // Main method

&#x20;   public static void main(String\[] args) {



&#x20;       Scanner sc = new Scanner(System.in);



&#x20;       System.out.print("Enter n: ");

&#x20;       int n = sc.nextInt();



&#x20;       if (n < 0) {

&#x20;           System.out.println("Enter positive number");

&#x20;           sc.close();

&#x20;           return;

&#x20;       }



&#x20;       System.out.println("Fibonacci(" + n + ") = " + fib(n));

&#x20;       System.out.println("Step Count (Recursive): " + recursiveCount);



&#x20;       System.out.println("Fibonacci(" + n + ") = " + iterative(n));



&#x20;       sc.close();

&#x20;   }

}



### 

### 







# HUFFMAN ENCODING





import java.util.\*;



class Node {

&#x20;   char ch;

&#x20;   int freq;

&#x20;   Node left, right;



&#x20;   Node(char ch, int freq) {

&#x20;       this.ch = ch;

&#x20;       this.freq = freq;

&#x20;       left = right = null;

&#x20;   }

}



public class Huffman {



&#x20;   static void printCodes(Node root, String code) {



&#x20;       if (root == null)

&#x20;           return;



&#x20;       // Leaf node means character found

&#x20;       if (root.left == null \&\& root.right == null) {

&#x20;           System.out.println(root.ch + " : " + code);

&#x20;           return;

&#x20;       }



&#x20;       // Left = 0

&#x20;       printCodes(root.left, code + "0");



&#x20;       // Right = 1

&#x20;       printCodes(root.right, code + "1");

&#x20;   }



&#x20;   public static void main(String\[] args) {



&#x20;       Scanner sc = new Scanner(System.in);



&#x20;       System.out.println("Enter a string:");

&#x20;       String str = sc.nextLine();



&#x20;       int\[] freq = new int\[256];



&#x20;       // Count character frequencies

&#x20;       for (char c : str.toCharArray()) {

&#x20;           freq\[c]++;

&#x20;       }



&#x20;       // Min Priority Queue

&#x20;       PriorityQueue<Node> pq =

&#x20;           new PriorityQueue<>(

&#x20;               (a, b) -> Integer.compare(a.freq, b.freq)

&#x20;           );



&#x20;       // Create leaf nodes

&#x20;       for (int i = 0; i < 256; i++) {

&#x20;           if (freq\[i] > 0) {

&#x20;               pq.add(new Node((char)i, freq\[i]));

&#x20;           }

&#x20;       }



&#x20;       // Build Huffman Tree

&#x20;       while (pq.size() > 1) {



&#x20;           Node left = pq.poll();

&#x20;           Node right = pq.poll();



&#x20;           Node parent = new Node(

&#x20;               '\\0', left.freq + right.freq

&#x20;           );



&#x20;           parent.left = left;

&#x20;           parent.right = right;



&#x20;           pq.add(parent);

&#x20;       }



&#x20;       // Print Huffman Codes

&#x20;       System.out.println("Huffman Codes:");



&#x20;       if (!pq.isEmpty()) {

&#x20;           Node root = pq.poll();



&#x20;           if (root.left == null \&\& root.right == null)

&#x20;               System.out.println(root.ch + " : 0");

&#x20;           else

&#x20;               printCodes(root, "");

&#x20;       }



&#x20;       sc.close();

&#x20;   }

}



























### 

### 

### KNAPSACK DP 01

import java.util.\*;



public class Knapsack {



&#x20;   public static void main(String\[] args) {



&#x20;       Scanner sc = new Scanner(System.in);



&#x20;       // Input number of items

&#x20;       System.out.print("Enter number of items: ");

&#x20;       int n = sc.nextInt();



&#x20;       int p\[] = new int\[n + 1];

&#x20;       int wt\[] = new int\[n + 1];



&#x20;       // Input profits

&#x20;       System.out.println("Enter profits:");

&#x20;       for (int i = 1; i <= n; i++) {

&#x20;           p\[i] = sc.nextInt();

&#x20;       }



&#x20;       // Input weights

&#x20;       System.out.println("Enter weights:");

&#x20;       for (int i = 1; i <= n; i++) {

&#x20;           wt\[i] = sc.nextInt();

&#x20;       }



&#x20;       // Input capacity

&#x20;       System.out.print("Enter knapsack capacity: ");

&#x20;       int m = sc.nextInt();



&#x20;       // Create DP table

&#x20;       int k\[]\[] = new int\[n + 1]\[m + 1];



&#x20;       // Fill DP table

&#x20;       for (int i = 0; i <= n; i++) {



&#x20;           for (int w = 0; w <= m; w++) {



&#x20;               if (i == 0 || w == 0) {

&#x20;                   k\[i]\[w] = 0;

&#x20;               }



&#x20;               else if (wt\[i] <= w) {



&#x20;                   k\[i]\[w] = Math.max(

&#x20;                       p\[i] + k\[i - 1]\[w - wt\[i]],

&#x20;                       k\[i - 1]\[w]

&#x20;                   );

&#x20;               }



&#x20;               else {

&#x20;                   k\[i]\[w] = k\[i - 1]\[w];

&#x20;               }

&#x20;           }

&#x20;       }



&#x20;       // Print maximum profit

&#x20;       System.out.println("\\nMaximum Profit: " + k\[n]\[m]);



&#x20;       // Backtracking to find selected items

&#x20;       System.out.println("\\nSelected Items:");



&#x20;       int i = n, j = m;



&#x20;       while (i > 0 \&\& j > 0) {



&#x20;           if (k\[i]\[j] == k\[i - 1]\[j]) {



&#x20;               System.out.println("Item " + i + " = 0");

&#x20;               i--;

&#x20;           }



&#x20;           else {



&#x20;               System.out.println("Item " + i + " = 1");



&#x20;               j = j - wt\[i];

&#x20;               i--;

&#x20;           }

&#x20;       }



&#x20;       sc.close();

&#x20;   }

}

























### NQUEENS 



import java.util.\*;



class NQueen {

&#x20;   static int n;

&#x20;   static int b\[]\[];

&#x20;   static boolean col\[], d1\[], d2\[];



&#x20;   // Backtracking: check safety using loops

&#x20;   static boolean safe(int r, int c) {

&#x20;       for (int i = 0; i < r; i++)

&#x20;           if (b\[i]\[c] == 1) return false;



&#x20;       for (int i = r-1, j = c-1; i >= 0 \&\& j >= 0; i--, j--)

&#x20;           if (b\[i]\[j] == 1) return false;



&#x20;       for (int i = r-1, j = c+1; i >= 0 \&\& j < n; i--, j++)

&#x20;           if (b\[i]\[j] == 1) return false;



&#x20;       return true;

&#x20;   }



&#x20;   // Backtracking method

&#x20;   static boolean backtrack(int r) {

&#x20;       if (r == n) return true;



&#x20;       for (int c = 0; c < n; c++) {

&#x20;           if (safe(r, c)) {

&#x20;               b\[r]\[c] = 1;



&#x20;               if (backtrack(r+1)) return true;



&#x20;               b\[r]\[c] = 0;

&#x20;           }

&#x20;       }

&#x20;       return false;

&#x20;   }



&#x20;   // Branch and Bound method

&#x20;   static boolean branchBound(int r) {

&#x20;       if (r == n) return true;



&#x20;       for (int c = 0; c < n; c++) {

&#x20;           if (!col\[c] \&\& !d1\[r-c+n-1] \&\& !d2\[r+c]) {

&#x20;               b\[r]\[c] = 1;

&#x20;               col\[c] = d1\[r-c+n-1] = d2\[r+c] = true;



&#x20;               if (branchBound(r+1)) return true;



&#x20;               b\[r]\[c] = 0;

&#x20;               col\[c] = d1\[r-c+n-1] = d2\[r+c] = false;

&#x20;           }

&#x20;       }

&#x20;       return false;

&#x20;   }



&#x20;   // Print board

&#x20;   static void printBoard() {

&#x20;       for (int i = 0; i < n; i++) {

&#x20;           for (int j = 0; j < n; j++)

&#x20;               System.out.print(b\[i]\[j] + " ");

&#x20;           System.out.println();

&#x20;       }

&#x20;   }



&#x20;   // Main method at bottom

&#x20;   public static void main(String args\[]) {

&#x20;       Scanner sc = new Scanner(System.in);



&#x20;       System.out.print("Enter N: ");

&#x20;       n = sc.nextInt();



&#x20;       System.out.println("1. Backtracking");

&#x20;       System.out.println("2. Branch and Bound");

&#x20;       System.out.print("Enter choice: ");

&#x20;       int ch = sc.nextInt();



&#x20;       b = new int\[n]\[n];



&#x20;       boolean ans = false;



&#x20;       if (ch == 1) {

&#x20;           ans = backtrack(0);

&#x20;       } else if (ch == 2) {

&#x20;           col = new boolean\[n];

&#x20;           d1 = new boolean\[2\*n-1];

&#x20;           d2 = new boolean\[2\*n-1];

&#x20;           ans = branchBound(0);

&#x20;       } else {

&#x20;           System.out.println("Invalid choice");

&#x20;           sc.close();

&#x20;           return;

&#x20;       }



&#x20;       if (ans)

&#x20;           printBoard();

&#x20;       else

&#x20;           System.out.println("No solution");



&#x20;       sc.close();

&#x20;   }

}









### QUICK SORT



import java.util.\*;



class QuickSort {



&#x20;   static Random random = new Random();



&#x20;   // Swap function

&#x20;   static void swap(int arr\[], int i, int j) {

&#x20;       int temp = arr\[i];

&#x20;       arr\[i] = arr\[j];

&#x20;       arr\[j] = temp;

&#x20;   }



&#x20;   // Partition function

&#x20;   static int partition(int arr\[], int low, int high) {

&#x20;       int pivot = arr\[high];

&#x20;       int i = low - 1;



&#x20;       for (int j = low; j < high; j++) {

&#x20;           if (arr\[j] <= pivot) {

&#x20;               i++;

&#x20;               swap(arr, i, j);

&#x20;           }

&#x20;       }



&#x20;       swap(arr, i + 1, high);



&#x20;       return i + 1;

&#x20;   }



&#x20;   // Quick Sort function

&#x20;   static void quickSort(int arr\[], int low, int high, int choice) {



&#x20;       if (low < high) {



&#x20;           // Randomized Quick Sort

&#x20;           if (choice == 2) {

&#x20;               int randomIndex = low + random.nextInt(high - low + 1);

&#x20;               swap(arr, randomIndex, high);

&#x20;           }



&#x20;           int pivotIndex = partition(arr, low, high);



&#x20;           quickSort(arr, low, pivotIndex - 1, choice);

&#x20;           quickSort(arr, pivotIndex + 1, high, choice);

&#x20;       }

&#x20;   }



&#x20;   // Main method

&#x20;   public static void main(String args\[]) {



&#x20;       Scanner sc = new Scanner(System.in);



&#x20;       System.out.print("Enter number of elements: ");

&#x20;       int n = sc.nextInt();



&#x20;       int arr\[] = new int\[n];



&#x20;       System.out.println("Enter array elements:");

&#x20;       for (int i = 0; i < n; i++)

&#x20;           arr\[i] = sc.nextInt();



&#x20;       System.out.println("1. Deterministic Quick Sort");

&#x20;       System.out.println("2. Randomized Quick Sort");

&#x20;       System.out.print("Enter choice: ");

&#x20;       int choice = sc.nextInt();



&#x20;       if (choice == 1 || choice == 2) {



&#x20;           quickSort(arr, 0, n - 1, choice);



&#x20;           System.out.println("Sorted Array:");

&#x20;           for (int i = 0; i < n; i++)

&#x20;               System.out.print(arr\[i] + " ");



&#x20;       } else {

&#x20;           System.out.println("Invalid choice");

&#x20;       }



&#x20;       sc.close();

&#x20;   }

}





