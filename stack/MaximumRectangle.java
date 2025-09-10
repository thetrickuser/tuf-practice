package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumRectangle {
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int maxArea = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int[] heights : matrix) {
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxRectangleArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek()[0];
                maxRectangleArea = Math.max(maxRectangleArea, top[1] * (i - pse - 1));
            }
            stack.push(new int[] { i, heights[i] });
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek()[0];
            maxRectangleArea = Math.max(maxRectangleArea, top[1] * (n - pse - 1));
        }

        return maxRectangleArea;
    }
}
