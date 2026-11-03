import java.util.*;

class NQueen {
    static int n;
    static int b[][];
    static boolean col[], d1[], d2[];

    // Backtracking: check safety using loops
    static boolean safe(int r, int c) {
        for (int i = 0; i < r; i++)
            if (b[i][c] == 1) return false;

        for (int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--)
            if (b[i][j] == 1) return false;

        for (int i = r-1, j = c+1; i >= 0 && j < n; i--, j++)
            if (b[i][j] == 1) return false;

        return true;
    }

    // Backtracking method
    static boolean backtrack(int r) {
        if (r == n) return true;

        for (int c = 0; c < n; c++) {
            if (safe(r, c)) {
                b[r][c] = 1;

                if (backtrack(r+1)) return true;

                b[r][c] = 0;
            }
        }
        return false;
    }

    // Branch and Bound method
    static boolean branchBound(int r) {
        if (r == n) return true;

        for (int c = 0; c < n; c++) {
            if (!col[c] && !d1[r-c+n-1] && !d2[r+c]) {
                b[r][c] = 1;
                col[c] = d1[r-c+n-1] = d2[r+c] = true;

                if (branchBound(r+1)) return true;

                b[r][c] = 0;
                col[c] = d1[r-c+n-1] = d2[r+c] = false;
            }
        }
        return false;
    }

    // Print board
    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }

    // Main method at bottom
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        n = sc.nextInt();

        System.out.println("1. Backtracking");
        System.out.println("2. Branch and Bound");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();

        b = new int[n][n];

        boolean ans = false;

        if (ch == 1) {
            ans = backtrack(0);
        } else if (ch == 2) {
            col = new boolean[n];
            d1 = new boolean[2*n-1];
            d2 = new boolean[2*n-1];
            ans = branchBound(0);
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        if (ans)
            printBoard();
        else
            System.out.println("No solution");

        sc.close();
    }
}


