/*
Problem: Find the Duplicate Number
LeetCode: 287
Difficulty: Medium

Approach:
- Use Floyd's Cycle Detection Algorithm.
- Treat array as a linked list.
- Find cycle entrance.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);

        slow = nums[0];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
