import java.util.*;

class Solution {

    int[][] dp;

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        // Calculate total sum
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;

        // dp[i][sum] stores the best possible sum
        dp = new int[stones.length][target + 1];

        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int best = solve(0, target, stones);

        // Minimum difference between two subsets
        return sum - 2 * best;
    }

    public int solve(int i, int sum, int[] stones) {
        if (i == stones.length) {
            return 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        // Take current stone
        if (stones[i] <= sum) {
            int take = stones[i]
                    + solve(i + 1, sum - stones[i], stones);

            // Don't take current stone
            int notake = solve(i + 1, sum, stones);

            return dp[i][sum] = Math.max(take, notake);
        }

        // Cannot take current stone
        return dp[i][sum] = solve(i + 1, sum, stones);
    }
}
