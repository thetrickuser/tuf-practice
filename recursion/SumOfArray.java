/**
 * Given an array nums, find the sum of elements of array using recursion.
 */
public class SumOfArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int sum = new SumOfArray().arraySum(nums);
        System.out.println(sum);
    }

    public int arraySum(int[] nums) {
        return sumHelper(0, nums);
    }

    private int sumHelper(int i, int[] nums) {
        if (i >= nums.length) return 0;
        return nums[i] + sumHelper(i + 1, nums);
    }
}
