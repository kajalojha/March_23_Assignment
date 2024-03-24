package March_22_Assignment;
import java.util.*;

public class Q4_Anagram_grouping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Length of the array/list of strings
            String[] inputStr = new String[N]; // Array to store strings

            // Reading the strings from the user input
            for (int i = 0; i < N; i++) {
                inputStr[i] = scanner.next();
            }

            // Function call
            List<List<String>> result = groupAnagrams(inputStr);

            // Printing the result
            for (List<String> group : result) {
                for (String str : group) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    public static List<List<String>> groupAnagrams(String[] inputStr) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        // Grouping anagrams
        for (String str : inputStr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }

        // Adding groups to the result
        for (List<String> group : map.values()) {
            result.add(group);
        }

        return result;
    }
}
