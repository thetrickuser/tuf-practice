package stack;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {4, -2, -3, 4, 1};
//        System.out.println(solution.subArrayRanges(nums));

        String num = "1002991";
        int k = 3;
        System.out.println(solution.removeKdigits(num, k));
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
        int[] nextSmaller = getNextIndex(arr, true, true);
        int[] previousSmallerEq = getPrevIndex(arr, true, false);
        return getContributionSum(arr, previousSmallerEq, nextSmaller);
    }

    public long sumSubarrayMaxs(int[] arr) {
        int[] nextGreater = getNextIndex(arr, false, true);
        int[] previousGreaterEq = getPrevIndex(arr, false, false);
        return getContributionSum(arr, previousGreaterEq, nextGreater);
    }

    private static long getContributionSum(int[] arr, int[] previousSmallerEq, int[] nextSmaller) {
        long sum = 0;
        for (int i = 0; i< arr.length; i++) {
            int left = i - previousSmallerEq[i];
            int right = nextSmaller[i] - i;
            long count = (long) left * right * arr[i];
            sum += count;
        }
        return sum;
    }

    private int[] getNextIndex(int[] arr, boolean smaller, boolean strict) {
        int[] result = new int[arr.length];

        Deque<Map.Entry<Integer,Integer>> stack = new ArrayDeque<>();

        for (int i=arr.length - 1; i>=0; i--) {
            while (!stack.isEmpty() && compare(stack.peek().getValue(), arr[i], smaller, strict)) {
                stack.pop();
            }
            if (stack.isEmpty()) result[i] = arr.length;
            else result[i] = stack.peek().getKey();
            stack.push(new AbstractMap.SimpleEntry<>(i, arr[i]));
        }

        return result;
    }

    private int[] getPrevIndex(int[] arr, boolean smaller, boolean strict) {
        int[] result = new int[arr.length];

        Deque<Map.Entry<Integer,Integer>> stack = new ArrayDeque<>();

        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && compare(stack.peek().getValue(), arr[i], smaller, strict)) {
                stack.pop();
            }
            if (stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek().getKey();
            stack.push(new AbstractMap.SimpleEntry<>(i, arr[i]));
        }

        return result;
    }

    private static boolean compare(int a, int b, boolean getSmaller, boolean strict) {
        if (getSmaller) {
            return strict ? a >= b : a > b;
        } else {
            return strict ? a <= b : a < b;
        }
    }

    public String removeKdigits(String nums, int k) {
        if (k >= nums.length()) return "0";
        Deque<Integer> stack = new ArrayDeque<>();

        int popped = 0;
        for (char c: nums.toCharArray()) {
            int i = c - '0';
            while (popped < k && !stack.isEmpty() && stack.peek() > i) {
                stack.pop();
                popped++;
            }
            stack.push(i);
        }

        long b = 0l;
        while (!stack.isEmpty()) {
            b = (b * 10) + stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(b);
        return String.valueOf(Long.parseLong(sb.reverse().toString()));


    }
}