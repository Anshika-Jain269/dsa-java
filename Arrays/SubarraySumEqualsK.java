/*
Problem: Subarray Sum Equals K
LeetCode: 560
Difficulty: Medium

Approach:
- Use Prefix Sum and HashMap.
- Store frequency of prefix sums.
- Check if (currentSum - k) exists.

Time Complexity: O(n)
Space Complexity: O(n)

Author: Anshika Jain
*/

import java.util.*;

class Solution {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
