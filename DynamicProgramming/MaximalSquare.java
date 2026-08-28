class Solution {

    /*
     * Approach:
     * We use Dynamic Programming to find the largest square
     * containing only '1's.
     *
     * dp[i][j] represents the side length of the largest square
     * whose bottom-right corner is at (i, j).
     *
     * If matrix[i][j] == '1':
     *
     *     dp[i][j] = 1 + min(
     *         dp[i-1][j],      // Top
     *         dp[i][j-1],      // Left
     *         dp[i-1][j-1]     // Diagonal
     *     )
     *
     * We take the minimum because all three neighboring squares
     * must be large enough to form a bigger square.
     *
     * For the first row or first column, the maximum square
     * possible is always of side 1.
     *
     * Finally, the problem asks for the area, so:
     *
     *     Area = side * side
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Stores the maximum square side ending at each cell
        int[][] dp = new int[m][n];

        int side = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {

                    // First row or first column
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }

                    else {
                        // Extend the square using top, left and diagonal cells
                        dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                dp[i][j - 1],
                                dp[i - 1][j - 1]
                            )
                        );
                    }
                }

                // Keep track of the largest square side
                side = Math.max(side, dp[i][j]);
            }
        }

        // Return area of the largest square
        return side * side;
    }
}
