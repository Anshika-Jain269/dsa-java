/*
 * Problem: LeetCode 342 - Power of Four
 *
 * Approach:
 * 1. If n is 1, return true because 4^0 = 1.
 * 2. If n is zero or negative, return false.
 * 3. Repeatedly check whether n is divisible by 4.
 * 4. If it is not divisible by 4, return false.
 * 5. Divide n by 4 until it becomes 1.
 * 6. If n becomes 1, it is a power of four.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isPowerOfFour(int n) {

        // 1 is a power of four (4^0)
        if (n == 1) {
            return true;
        }

        // Powers of four must be positive
        if (n <= 0) {
            return false;
        }

        // Repeatedly divide n by 4
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }

            n = n / 4;
        }

        // If n becomes 1, it is a power of four
        return true;
    }
}
