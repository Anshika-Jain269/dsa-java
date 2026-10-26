/*
 * Problem: LeetCode 306 - Additive Number
 *
 * Approach:
 * 1. Try every possible split for the first and second numbers.
 * 2. Reject numbers with leading zeros, except the number "0".
 * 3. Use BigInteger to avoid integer overflow.
 * 4. Calculate the sum of the previous two numbers.
 * 5. Check whether the remaining string starts with that sum.
 * 6. Continue until the entire string is consumed.
 * 7. Return true if a valid additive sequence is found.
 *
 * Time Complexity: Approximately O(n^3), excluding detailed
 * BigInteger arithmetic costs.
 * Space Complexity: O(n)
 */

import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {

        // An additive sequence requires at least three numbers
        if (num.length() < 3) {
            return false;
        }

        // Choose the ending index of the first number
        for (int i = 1; i < num.length() - 1; i++) {

            // Choose the ending index of the second number
            for (int j = i + 1; j < num.length(); j++) {
                String first = num.substring(0, i);
                String second = num.substring(i, j);

                // Reject leading zeros in the first number
                if (first.length() > 1 && first.charAt(0) == '0') {
                    continue;
                }

                // Reject leading zeros in the second number
                if (second.length() > 1 && second.charAt(0) == '0') {
                    continue;
                }

                // Use BigInteger to handle large numbers safely
                BigInteger a = new BigInteger(first);
                BigInteger b = new BigInteger(second);

                int k = j;

                // Verify the remaining additive sequence
                while (k < num.length()) {
                    BigInteger sum = a.add(b);
                    String next = sum.toString();

                    // The expected sum must match the next digits
                    if (!num.startsWith(next, k)) {
                        break;
                    }

                    // Move past the matched number
                    k += next.length();

                    // Shift the previous two numbers
                    a = b;
                    b = sum;
                }

                // All digits were consumed successfully
                if (k == num.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
