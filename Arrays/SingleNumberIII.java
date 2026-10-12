/*
 * Problem: LeetCode 260 - Single Number III
 *
 * Approach:
 * 1. Sort the array.
 * 2. Skip duplicate elements.
 * 3. Identify elements that are different from both
 *    their previous and next neighbors.
 * 4. Store the two unique elements in the result array.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 * (Excluding the sorting implementation's internal space.)
 */

import java.util.Arrays;

class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            // Skip an element if it is the same as the previous one
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Check whether the current element is unique
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                res[count] = nums[i];
                count++;
            }

            // Stop after finding both unique elements
            if (count == 2) {
                break;
            }
        }

        return res;
    }
}
