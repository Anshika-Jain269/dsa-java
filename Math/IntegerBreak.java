/*
 * Problem: LeetCode 343 - Integer Break
 *
 * Approach:
 * 1. Handle n = 2 and n = 3 as special cases.
 * 2. Repeatedly multiply the product by 3 while n > 4.
 * 3. Subtract 3 from n after each multiplication.
 * 4. Multiply the final product by the remaining n.
 *
 * Greedy Strategy:
 * Splitting a number into parts of 3 generally maximizes
 * the product. A remaining value of 4 is kept together
 * because 2 * 2 = 4.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int integerBreak(int n) {

        // Handle the smallest values
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int product = 1;

        // Multiply by 3 while leaving a remainder of at least 2
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        // Multiply by the remaining value
        return product * n;
    }
}
