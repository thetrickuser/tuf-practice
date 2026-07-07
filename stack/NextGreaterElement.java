package stack;

import java.util.ArrayDeque;

public class NextGreaterElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 5, 2, 25};
        int[] result = solution.nextLargerElement(arr);
        System.out.print("Next Greater Elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(arr[i]);
        }

        return ans;
    }
}
