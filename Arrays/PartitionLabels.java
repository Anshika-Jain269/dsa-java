// Problem: 763. Partition Labels
//
// Approach:
// 1. Store the last occurrence of every character in the string.
// 2. Traverse the string and find the farthest last occurrence
//    of all characters in the current partition.
// 3. When the current index reaches that farthest position,
//    we can safely create a partition.
// 4. Store the size of the partition and start a new partition.
//
// Time Complexity: O(n)
// Space Complexity: O(1)
//
// n = length of the string

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        int[] last = new int[26];

        // Store the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Find the farthest last occurrence
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // Partition can be completed
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }
}
