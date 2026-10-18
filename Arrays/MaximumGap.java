/*
 * Problem: LeetCode 164 - Maximum Gap
 *
 * Approach:
 * 1. Sort the array in ascending order.
 * 2. If the array contains fewer than two elements, return 0.
 * 3. Traverse adjacent elements and calculate their difference.
 * 4. Keep track of the maximum difference.
 * 5. Return the maximum gap.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) auxiliary space for typical Java sorting
 */

import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {

        // Sort the array in ascending order
        Arrays.sort(nums);

        // If fewer than two elements exist, no gap is possible
        if (nums.length < 2) {
            return 0;
        }

        int dif = 0;

        // Find the maximum difference between adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            dif = Math.max(dif, nums[i + 1] - nums[i]);
        }

        return dif;
    }
}
