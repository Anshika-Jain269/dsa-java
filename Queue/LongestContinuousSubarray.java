// Problem: 1438. Longest Continuous Subarray With Absolute
// Difference Less Than or Equal to Limit
//
// Approach:
// 1. Use a sliding window with two monotonic deques.
// 2. dq1 stores indices in decreasing order of values,
//    so its front gives the maximum value.
// 3. dq2 stores indices in increasing order of values,
//    so its front gives the minimum value.
// 4. If max - min becomes greater than limit, move the
//    left pointer and remove the outgoing index from the deques.
// 5. Update the maximum window length.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int count = 0;
        int left = 0;

        // Max Deque
        Deque<Integer> dq1 = new LinkedList<>();

        // Min Deque
        Deque<Integer> dq2 = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            // Maintain decreasing order for maximum
            while (!dq1.isEmpty()
                    && nums[dq1.peekLast()] <= nums[i]) {
                dq1.pollLast();
            }

            dq1.addLast(i);

            // Maintain increasing order for minimum
            while (!dq2.isEmpty()
                    && nums[dq2.peekLast()] >= nums[i]) {
                dq2.pollLast();
            }

            dq2.addLast(i);

            // Shrink window if difference exceeds limit
            while (nums[dq1.peekFirst()] - nums[dq2.peekFirst()] > limit) {

                if (dq1.peekFirst() == left) {
                    dq1.pollFirst();
                }

                if (dq2.peekFirst() == left) {
                    dq2.pollFirst();
                }

                left++;
            }

            // Update maximum length
            count = Math.max(count, i - left + 1);
        }

        return count;
    }
}
