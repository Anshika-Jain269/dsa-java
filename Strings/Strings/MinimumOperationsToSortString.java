/*
 * Problem: Minimum Operations to Sort a String
 *
 * Approach:
 * 1. Sort the characters to identify the smallest and largest characters.
 * 2. If the string is already sorted, return 0.
 * 3. If the length is 2 and the string is not sorted, return -1.
 * 4. If the first character is the smallest or the last character is the largest, return 1.
 * 5. If the smallest or largest character is at an interior position, return 2.
 * 6. Otherwise, return 3.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        if (s.equals(new String(arr))) {
            return 0;
        }

        int n = s.length();

        if (n == 2) {
            return -1;
        }

        char smallest = arr[0];
        char largest = arr[n - 1];

        if (s.charAt(0) == smallest ||
            s.charAt(n - 1) == largest) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == smallest ||
                s.charAt(i) == largest) {
                return 2;
            }
        }

        return 3;
    }
}
