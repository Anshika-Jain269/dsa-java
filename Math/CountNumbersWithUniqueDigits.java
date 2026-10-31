/*
 * Problem: Count Numbers with Unique Digits
 *
 * Approach:
 * Count the one-digit numbers, then count numbers with 2 through n digits.
 * For each additional digit, multiply by the number of digits still available.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 10;
        int current = 9;

        for (int i = 2; i <= n; i++) {
            current *= (11 - i);
            count += current;
        }

        return count;
    }
}
