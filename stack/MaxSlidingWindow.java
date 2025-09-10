package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= (k - 1)) {
                ans[ansIndex++] = arr[dq.peekFirst()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        MaxSlidingWindow sol = new MaxSlidingWindow();

        int[] ans = sol.maxSlidingWindow(arr, k);

        System.out.print("The maximum elements in the sliding window are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }


}
