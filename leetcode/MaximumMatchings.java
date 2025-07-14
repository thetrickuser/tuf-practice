package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumMatchings {

    public static void main(String[] args) {
        MaximumMatchings mm = new MaximumMatchings();
        int[] players = {4, 5, 6};
        int[] trainers = {3, 4, 5};
        System.out.println(mm.matchPlayersAndTrainers(players, trainers)); // Output: 2
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i: trainers) {
            maxHeap.offer(i);
        }

        int count = 0;

        Arrays.sort(players);
        int n = players.length;

        for (int i=n-1; i>=0; i--) {
            if (maxHeap.isEmpty()) break;

            if (players[i] <= maxHeap.peek()) {
                maxHeap.poll();
                count++;
            }
        }

        return count;
    }
}
