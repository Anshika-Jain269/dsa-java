// Problem: 1696. Jump Game VI
//
// Approach:
// 1. Use a Max Heap to store {maximum score, index}.
// 2. For every position, remove elements that are outside
//    the current window of k positions.
// 3. Take the maximum score from the heap.
// 4. Add the current nums[i] to that score.
// 5. Store the current score back in the heap.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {

        int n = nums.length;

        // Max Heap: {score, index}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        pq.add(new int[]{nums[0], 0});

        int sum = nums[0];

        for (int i = 1; i < n; i++) {

            // Remove indices outside the window
            while (!pq.isEmpty() && pq.peek()[1] < i - k) {
                pq.poll();
            }

            // Maximum score from previous k positions
            sum = nums[i] + pq.peek()[0];

            // Add current score and index
            pq.add(new int[]{sum, i});
        }

        return sum;
    }
}
