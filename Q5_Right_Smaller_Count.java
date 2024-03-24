package March_22_Assignment;
import java.util.Scanner;
public class Q5_Right_Smaller_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Length of the array
            int[] arr = new int[N]; // Array to store elements

            // Reading the array from the user input
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            // Function call
            int[] countArray = rightSmallerCount(arr);

            // Printing the result
            for (int count : countArray) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static int[] rightSmallerCount(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count[i]++;
                }
            }
        }

        return count;
    }
}
