package March_22_Assignment;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Q3_SubArrayWithOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Length of the array
        int k = scanner.nextInt(); // Number of ones we are looking for
        int[] arr = new int[N]; // Array to store binary elements

        // Reading the array from the user input
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Function call
        int result = countSubarrays(arr, k);
        System.out.println(result);
        scanner.close();
    }

    public static int countSubarrays(int[] arr, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // Initialize a HashMap to store prefix sums and their counts
        int count = 0;
        int currSum = 0;

        for (int num : arr) {
            currSum += num;
            if (prefixSum.containsKey(currSum - k)) {
                count += prefixSum.get(currSum - k);
            }
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
