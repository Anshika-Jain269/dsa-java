/*
Problem: Longest Common Prefix
LeetCode: 14
Difficulty: Easy

Approach:
- Sort the array of strings.
- After sorting, the common prefix of the first and last strings
  will be the common prefix of the entire array.
- Compare characters of the first and last strings until they differ.
- Return the matching prefix.

Time Complexity: O(n log n * m)
Space Complexity: O(1)

Author: Anshika Jain
*/

import java.util.Arrays;

class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);

        String start = strs[0];
        String end = strs[strs.length - 1];

        int i = 0;

        while (i < start.length()
                && i < end.length()
                && start.charAt(i) == end.charAt(i)) {

            i++;
        }

        return start.substring(0, i);
    }
}
