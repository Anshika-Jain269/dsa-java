/*
 * Problem: Minimum Moves to Equal Array Elements
 *
 * Approach:
 * Incrementing n - 1 elements by 1 is equivalent to decrementing
 * one element by 1. Therefore, make every element equal to the
 * minimum element and calculate the total decrements needed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int small = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] < small) {
                small = nums[i];
            }
        }

        return sum - (nums.length * small);
    }
}
