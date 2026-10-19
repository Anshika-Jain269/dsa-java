/*
 * Problem: LeetCode 2089 - Find Target Indices After Sorting Array
 *
 * Approach:
 * 1. Sort the array in ascending order.
 * 2. Traverse the sorted array.
 * 3. If an element equals the target, add its index to the list.
 * 4. Return the list of target indices.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n) for the result list
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        // Sort the array in ascending order
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        // Find all indices containing the target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }

        return list;
    }
}
