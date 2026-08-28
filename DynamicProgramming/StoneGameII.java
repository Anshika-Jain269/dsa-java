import java.util.Arrays;

class Solution {

    /*
     * Approach:
     * We use Dynamic Programming with Recursion + Memoization.
     *
     * State:
     * dp[index][m] represents the maximum number of stones
     * the current player can collect starting from 'index'
     * when the current value of M is 'm'.
     *
     * Suffix Sum:
     * suffix[index] stores the total number of stones from
     * index to the end.
     * This helps us calculate the remaining stones quickly.
     *
     * For each state, the player can take between 1 and 2 * M stones.
     * After taking i stones, the new value of M becomes:
     *
     * newM = max(M, i)
     *
     * If the opponent can collect 'opponent' stones from the
     * remaining piles, then the current player can collect:
     *
     * current = suffix[index] - opponent
     *
     * We try all possible choices and take the maximum.
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     */

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        // dp[index][m] stores the answer for each state
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // suffix[i] = total stones from index i to the end
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // Start from index 0 with M = 1
        return solve(piles, 0, 1, dp, suffix);
    }

    public int solve(int[] piles, int index, int m,
                     int[][] dp, int[] suffix) {

        // No piles left
        if (index >= piles.length) {
            return 0;
        }

        // Return already calculated result
        if (dp[index][m] != -1) {
            return dp[index][m];
        }

        int best = 0;

        // Try taking 1 to 2 * M piles
        for (int i = 1; i <= 2 * m && index + i <= piles.length; i++) {

            // Update M for the next state
            int newm = Math.max(m, i);

            // Maximum stones opponent can collect
            int opponent = solve(
                piles, index + i, newm, dp, suffix
            );

            // Total remaining stones - opponent's stones
            int current = suffix[index] - opponent;

            // Choose the best possible move
            best = Math.max(best, current);
        }

        // Store the result for this state
        dp[index][m] = best;

        return best;
    }
}
