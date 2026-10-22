import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public boolean isConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (set.size() != nums.length) {
            return false;
        }

        return max - min + 1 == nums.length;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[2];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int top = -1, left = -1, right = -1, bottom = -1;
                if (i>0) top = mat[i-1][j];
                if (i<n-1) bottom = mat[i+1][j];
                if (j>0) left = mat[i][j-1];
                if (j<m-1) right = mat[i][j+1];

                if (mat[i][j] > top && mat[i][j] > bottom && mat[i][j] > left && 
                mat[i][j] > right) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;  
    }

    public String capitalizeFirstLast(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.setCharAt(n - 1, Character.toUpperCase(sb.charAt(n - 1)));
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i - 1, Character.toUpperCase(sb.charAt(i - 1)));
                sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i + 1)));
            }
        }

        return sb.toString();
    }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // Your code goes here
        Map<Integer, Integer> counts = new HashMap<>();

        ListNode temp = head;
        while (temp != null) {
            counts.compute(temp.val, (key, val) -> (val != null) ? val + 1 : 1);
            temp = temp.next;
        }

        ListNode prev = null;
        temp = head;

        while (temp != null) {
            if (counts.get(temp.val) > 1) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }

    public String findContestMatch(int n) {
        // Your code goes here
        List<String> list = new ArrayList<>();
        String match = "";

        IntStream.rangeClosed(1, n).mapToObj(String::valueOf).forEach(list::add);

        while (list.size() > 1) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < list.size() / 2; i++) {
                match = "(" + list.get(i) + "," + list.get(list.size() - 1 - i) + ")";
                tempList.add(match);
            }
            list = tempList;
        }

        return list.get(0);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long qt = 0l;
        long ldivn = Math.abs((long) dividend);
        long ldivs = Math.abs((long) divisor);

        
        long curr = ldivs;
        int k = 0;

        while (ldivn >= (curr << 1) && (curr << 1) > 0) {
            curr <<= 1;
            k++;
        }

        for (int i=k; i>=0; i--) {
            if (ldivn >= (ldivs << i)) {
                ldivn -= (ldivs << i);
                qt += (1L << i);
            }
        }

        qt = isNegative ? -qt : qt;

        if (qt < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (qt > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) qt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int dividend = 216;
        int divisor = 7;
        int result = solution.divide(dividend, divisor);
        System.out.println("Result of division: " + result);
    }
}