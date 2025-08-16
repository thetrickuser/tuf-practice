package bits;

public class SingleNumber {
    public static void main(String[] args) {
        // Example usage
        SingleNumber sn = new SingleNumber();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = sn.singleNumber(nums);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }


    public int[] singleNumber(int[] nums) {
        //your code goes here
        int xor = 0;
        for (int i : nums) {
            xor = xor ^ i;
        }

        int diff = xor & (-xor);
        int n1 = 0, n2 = 0;

        for (int i : nums) {
            if ((i & diff) == 0) {
                n1 = n1 ^ i;
            } else {
                n2 = n2 ^ i;
            }
        }

        if (n1 > n2) {
            return new int[]{n2, n1};
        }
        return new int[]{n1, n2};
    }

}
