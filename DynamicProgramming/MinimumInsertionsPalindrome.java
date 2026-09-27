import java.util.*;

class Solution {

    int[][] dp;

    public int minInsertions(String s) {
        dp = new int[s.length()][s.length()];

        // Initialize DP with -1
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, s.length() - 1);
    }

    public int solve(String s, int i, int j) {

        // One or zero characters is already a palindrome
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters already match
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, j - 1);
        }

        // Insert a character on either side
        return dp[i][j] = 1 + Math.min(
            solve(s, i + 1, j),
            solve(s, i, j - 1)
        );
    }
}
