package greedy;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
//        int[][] jobs = {
//            {1, 2, 100},
//            {2, 1, 19},
//            {3, 2, 27},
//            {4, 1, 25},
//            {5, 1, 15}
//        };
//        int[] result = solution.JobScheduling(jobs);
//        System.out.println("Number of jobs: " + result[0] + ", Total profit: " + result[1]);

        int[][] intervals = {
            {1, 3},
            {2, 4},
            {3, 5},
            {6, 8},
            {7, 9}
        };
        int maxNonOverlapping = solution.MaximumNonOverlappingIntervals(intervals);
        System.out.println("Maximum non-overlapping intervals: " + maxNonOverlapping);
    }
    public int[] JobScheduling(int[][] Jobs) {
        //your code goes here
        int n = Jobs.length;

        int[] profits = new int[n+1];
        for (int i=0; i<profits.length; i++) {
            profits[i] = 0;
        }

        for (int[] job: Jobs) {
            if (profits[job[1]] < job[2]) {
                profits[job[1]] = job[2];
            }
        }

        int[] ans = new int[2];
        for (int i=0; i<profits.length; i++) {
            if (profits[i] != 0) {
                ans[0]++;
                ans[1] += profits[i];
            }
        } 

        return ans;





    }

    public int MaximumNonOverlappingIntervals(int[][] Intervals) {
        //your code goes here
        Arrays.sort(Intervals, (i1, i2) -> i1[1] - i2[1]);
        int count = 1;

        int last = Intervals[0][1];

        for (int i=1; i<Intervals.length; i++) {
            if (last > Intervals[i][0]) {
                count++;
            } else {
                last = Intervals[i][1];
            }
        }

        return count;
    }
}