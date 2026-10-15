/*
 * Problem: LeetCode 2913 - Subarrays Distinct Element Sum of Squares I
 *
 * Approach:
 * 1. Start a subarray from each index i.
 * 2. Use a HashSet to store distinct elements in the subarray.
 * 3. Extend the subarray by moving index j.
 * 4. Add the square of the distinct element count to the result.
 *
 * Time Complexity: O(n^2) average
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int count = 0;

        // Consider every possible starting index
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();

            // Extend the subarray from index i
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));

                // Add the square of the number of distinct elements
                count += set.size() * set.size();
            }
        }

        return count;
    }
}
