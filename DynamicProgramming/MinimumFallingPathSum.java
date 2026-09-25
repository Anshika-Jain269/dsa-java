class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // First row
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                }

                // First column
                else if (j == 0) {
                    dp[i][j] = matrix[i][j]
                            + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }

                // Last column
                else if (j == col - 1) {
                    dp[i][j] = matrix[i][j]
                            + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }

                // Middle columns
                else {
                    dp[i][j] = matrix[i][j]
                            + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
            }
        }

        // Find minimum value in the last row
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < col; j++) {
            ans = Math.min(ans, dp[row - 1][j]);
        }

        return ans;
    }
}
