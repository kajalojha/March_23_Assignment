package March_22_Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_MedianOfMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases != 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int median = findMedian(matrix);
            System.out.println(median);
        }
        scanner.close();
    }

    private static int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] mergedArray = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mergedArray[index++] = matrix[i][j];
            }
        }
        Arrays.sort(mergedArray);
        return mergedArray[(rows * cols) / 2];
    }
}
