
import java.util.*;

class Back {

    static boolean safe(int board[][], int row, int col, int n) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solve(int board[][], int row, int n) {

        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {

            if (safe(board, row, col, n)) {

                board[row][col] = 1;

                if (solve(board, row + 1, n))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    static void printBoard(int board[][], int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int board[][] = new int[n][n];

        System.out.print("Enter first Queen row: ");
        int row = sc.nextInt();

        System.out.print("Enter first Queen column: ");
        int col = sc.nextInt();

        // Convert to 0-based indexing
        row--;
        col--;

        if (n <= 0 || row < 0 || row >= n ||
            col < 0 || col >= n) {

            System.out.println("Invalid position");
        }
        else {

            board[row][col] = 1;

            if (solve(board, row + 1, n)) {
                System.out.println("Solution:");
                printBoard(board, n);
            }
            else {
                System.out.println("No solution exists");
            }
        }

        sc.close();
    }
}
