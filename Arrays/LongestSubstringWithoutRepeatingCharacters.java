/*
Problem: Longest Substring Without Repeating Characters
LeetCode: 3
Difficulty: Medium

Approach:
- Use a sliding window and HashSet.
- Expand the window by moving right pointer.
- Remove characters from left until duplicate is removed.

Time Complexity: O(n)
Space Complexity: O(n)

Author: Anshika Jain
*/

import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength,
                    right - left + 1);
        }

        return maxLength;
    }
}
