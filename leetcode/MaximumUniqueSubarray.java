package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumUniqueSubarray {

    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] nums = {4, 2, 4, 5, 6};
        System.out.println(sln.maximumUniqueSubarray(nums)); // Output: 17
    }

    static class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();

            int currScore = 0;
            int maxScore = 0;

            for (int n: nums) {
                if (map.containsKey(n)) {
                    while (!stack.isEmpty()) {
                        int k = stack.pop();
                        if (k != n) {
                            stack2.push(k);
                        } else {
                            break;
                        }
                    }

                    stack.clear();
                    map.clear();
                    currScore = 0;

                    while (!stack2.isEmpty()) {
                        int k = stack2.pop();
                        currScore += k;
                        stack.push(k);
                        map.put(k, null);
                    }

                }
                currScore += n;
                maxScore = Math.max(currScore, maxScore);
                stack.push(n);
                map.put(n, null);
            }

            return maxScore;

        }
    }
}
