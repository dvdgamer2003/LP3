import java.util.*;

public class Knapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int p[] = new int[n + 1];
        int wt[] = new int[n + 1];

        // Input profits
        System.out.println("Enter profits:");
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        // Input weights
        System.out.println("Enter weights:");
        for (int i = 1; i <= n; i++) {
            wt[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("Enter knapsack capacity: ");
        int m = sc.nextInt();

        // Create DP table
        int k[][] = new int[n + 1][m + 1];

        // Fill DP table
        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= m; w++) {

                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                }

                else if (wt[i] <= w) {

                    k[i][w] = Math.max(
                        p[i] + k[i - 1][w - wt[i]],
                        k[i - 1][w]
                    );
                }

                else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }

        // Print maximum profit
        System.out.println("\nMaximum Profit: " + k[n][m]);

        // Backtracking to find selected items
        System.out.println("\nSelected Items:");

        int i = n, j = m;

        while (i > 0 && j > 0) {

            if (k[i][j] == k[i - 1][j]) {

                System.out.println("Item " + i + " = 0");
                i--;
            }

            else {

                System.out.println("Item " + i + " = 1");

                j = j - wt[i];
                i--;
            }
        }

        sc.close();
    }
}



/*Time Complexity
O(n*m)
- Outer loop runs \(n+1\) times (items).
- Inner loop runs \(m+1\) times (capacity).*/