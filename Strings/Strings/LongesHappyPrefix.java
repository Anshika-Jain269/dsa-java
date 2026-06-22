/*
Problem: Longest Happy Prefix
LeetCode: 1392
Difficulty: Hard

Approach:
- A happy prefix is a prefix that is also a suffix
  but not equal to the entire string.
- Use the KMP (Longest Prefix Suffix - LPS) array.
- Build the LPS array for the string.
- The last value of the LPS array gives the length
  of the longest happy prefix.

Time Complexity: O(n)
Space Complexity: O(n)

Author: Anshika Jain
*/

class Solution {

    public String longestPrefix(String s) {

        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int prefixLength = lps[n - 1];

        return s.substring(0, prefixLength);
    }
}
