import java.util.*;

class QuickSort {

    static Random random = new Random();

    // Swap function
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition function
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    // Quick Sort function
    static void quickSort(int arr[], int low, int high, int choice) {

        if (low < high) {

            // Randomized Quick Sort
            if (choice == 2) {
                int randomIndex = low + random.nextInt(high - low + 1);
                swap(arr, randomIndex, high);
            }

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1, choice);
            quickSort(arr, pivotIndex + 1, high, choice);
        }
    }

    // Main method
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("1. Deterministic Quick Sort");
        System.out.println("2. Randomized Quick Sort");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1 || choice == 2) {

            quickSort(arr, 0, n - 1, choice);

            System.out.println("Sorted Array:");
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");

        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}