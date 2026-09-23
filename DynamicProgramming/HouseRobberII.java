import java.util.*;

class Solution {

    int[] dp;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // Case 1: Rob houses from 0 to n-2
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int case1 = solve(nums, 0, nums.length - 2);

        // Case 2: Rob houses from 1 to n-1
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int case2 = solve(nums, 1, nums.length - 1);

        return Math.max(case1, case2);
    }

    public int solve(int[] nums, int i, int end) {
        if (i > end) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Skip current house
        int skip = solve(nums, i + 1, end);

        // Rob current house
        int steal = nums[i] + solve(nums, i + 2, end);

        int ans = Math.max(skip, steal);

        return dp[i] = ans;
    }
}
