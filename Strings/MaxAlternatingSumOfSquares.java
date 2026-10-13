/*
 * Problem: Maximum Alternating Sum of Squares
 *
 * Approach:
 * 1. Square each element and store it in a long array.
 * 2. Sort the squared values in ascending order.
 * 3. Subtract the smaller half of the values from the score.
 * 4. Add the larger half of the values to maximize the score.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        // Calculate the square of each element
        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        // Sort the squared values in ascending order
        Arrays.sort(squares);

        long score = 0;
        int n = squares.length;

        // Subtract the smaller half and add the larger half
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                score -= squares[i];
            } else {
                score += squares[i];
            }
        }

        return score;
    }
}
