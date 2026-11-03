import java.util.Scanner;

class Fibonacci {

    static int recursiveCount = 0;

    // Recursive method
    static int fib(int n) {

        recursiveCount++;

        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    // Non-recursive method
    static int iterative(int n) {

        int a = 0, b = 1, c;
        int count = 0;

        for (int i = 2; i <= n; i++) {

            c = a + b;
            a = b;
            b = c;

            count++;
        }

        System.out.println("Step Count (Non-Recursive): " + count);

        return (n == 0) ? 0 : b;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Enter positive number");
            sc.close();
            return;
        }

        System.out.println("Fibonacci(" + n + ") = " + fib(n));
        System.out.println("Step Count (Recursive): " + recursiveCount);

        System.out.println("Fibonacci(" + n + ") = " + iterative(n));

        sc.close();
    }
}



//Recursive: O(2^n)



//Non-recursive: O(n)