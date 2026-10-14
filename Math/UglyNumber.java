/*
 * Problem: LeetCode 263 - Ugly Number
 *
 * Approach:
 * 1. If n is less than or equal to 0, return false.
 * 2. Repeatedly divide n by 2, 3, or 5 whenever divisible.
 * 3. If n becomes 1, it is an ugly number.
 * 4. Otherwise, it contains a prime factor other than 2, 3, or 5.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isUgly(int n) {

        // Ugly numbers must be positive
        if (n <= 0) {
            return false;
        }

        // Remove all factors of 2, 3, and 5
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                // A prime factor other than 2, 3, or 5 exists
                break;
            }
        }

        // An ugly number reduces to 1
        return n == 1;
    }
}
