/*
 * Problem: Minimum Cost (verify the exact platform title)
 *
 * Approach:
 * 1. Use a DP array where dp[j][x] indicates whether XOR value x
 *    is achievable at column j of the current row.
 * 2. Start from the top-left cell with its value as the XOR result.
 * 3. For every other cell, consider paths from above and from the left.
 * 4. XOR the previous result with the current cell's value.
 * 5. After processing the grid, return the smallest achievable XOR.
 *
 * Time Complexity: O(m * n * 1024)
 * Space Complexity: O(n * 1024)
 */

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[j][x] indicates whether XOR value x is achievable
        boolean[][] dp = new boolean[n][1024];

        // Traverse every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] cur = new boolean[1024];
                int v = grid[i][j];

                // Initialize the starting cell
                if (i == 0 && j == 0) {
                    cur[v] = true;
                } else {
                    // Try every possible XOR value
                    for (int x = 0; x < 1024; x++) {

                        // Transition from the cell above
                        if (i > 0 && dp[j][x]) {
                            cur[x ^ v] = true;
                        }

                        // Transition from the cell to the left
                        if (j > 0 && dp[j - 1][x]) {
                            cur[x ^ v] = true;
                        }
                    }
                }

                // Store the current cell's reachable XOR values
                dp[j] = cur;
            }
        }

        // Find the minimum achievable XOR at the bottom-right cell
        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
