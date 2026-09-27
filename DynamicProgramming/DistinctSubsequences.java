import java.util.*;

class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];

        // Initialize DP with -1
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, t, 0, 0);
    }

    public int solve(String s, String t, int i, int j) {

        // Entire target string is matched
        if (j == t.length()) {
            return 1;
        }

        // Source string is finished before target
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match, we can take or skip
        if (s.charAt(i) == t.charAt(j)) {

            int take = solve(s, t, i + 1, j + 1);
            int notake = solve(s, t, i + 1, j);

            return dp[i][j] = take + notake;
        }

        // Characters do not match, so skip current character
        return dp[i][j] = solve(s, t, i + 1, j);
    }
}
