/*
Problem: Product of Array Except Self
LeetCode: 238
Difficulty: Medium

Approach:
- Build prefix products.
- Traverse from right and multiply suffix products.
- No division used.

Time Complexity: O(n)
Space Complexity: O(1) excluding output

Author: Anshika Jain
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] *= suffix;

            suffix *= nums[i];
        }

        return result;
    }
}
