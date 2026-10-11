/*
 * Problem: LeetCode 2778 - Sum of Squares of Special Elements
 *
 * Approach:
 * Traverse the array and check whether the 1-based index divides
 * the array length. If it does, add the square of that element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {

            // Check if the 1-based index divides the array length
            if (n % (i + 1) == 0) {

                // Add the square of the special element
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }
}
