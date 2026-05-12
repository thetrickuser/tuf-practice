/**
 * Given an array nums, find the sum of elements of array using recursion.
 */

int arraySum(int[] nums) {
    return sumHelper(0, nums);
}

int sumHelper(int i, int[] nums) {
    if (i >= nums.length) return 0;

    return nums[i] + sumHelper(i + 1, nums);
}


void main() {
    int[] nums = new int[]{1};
    int sum = arraySum(nums);
    System.out.println(sum);
}
