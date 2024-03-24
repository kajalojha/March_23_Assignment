package March_22_Assignment;
import java.util.Scanner;
public class Q1_Max_length_subString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T != 0) {
            int K = scanner.nextInt(); // Maximum distinct characters allowed
            String S = scanner.next(); // Input string

            int maxLength = MaxLengthSubstring(S, K);
            System.out.println(maxLength);
        }

        scanner.close();
    }

    public static int MaxLengthSubstring(String s, int k) {
        int maxLength = 0;
        int[] count = new int[26]; // Assuming input string contains only lowercase English letters

        int left = 0, right = 0;
        int distinctChars = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (count[c - 'a'] == 0) {
                distinctChars++;
            }
            count[c - 'a']++;

            // If number of distinct characters exceeds K, move left pointer
            while (distinctChars > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'a']--;
                if (count[leftChar - 'a'] == 0) {
                    distinctChars--;
                }
                left++;
            }

            // Update maxLength if applicable
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
