/*
Problem: Maximum Subarray
LeetCode: 53
Difficulty: Medium

Approach:
- Use Kadane's Algorithm.
- At each index, decide whether to:
  1. Start a new subarray from the current element.
  2. Extend the previous subarray.
- Keep track of the maximum sum found so far.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either start a new subarray or extend the current one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
