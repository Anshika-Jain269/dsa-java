import java.util.Arrays;

/*
 * Problem: Minimum Moves to Equal Array Elements II
 *
 * Approach:
 * Sort the array and choose its middle element (the median).
 * The sum of absolute differences is minimized when every
 * element is moved to the median.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space, excluding sorting internals
 */

class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0;

        Arrays.sort(nums);
        int mid = nums[nums.length / 2];

        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - mid);
        }

        return sum;
    }
}
