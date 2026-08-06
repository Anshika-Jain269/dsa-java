class Solution {

    // Starts the validation from the top-left cell (0,0)
    // with the expected first value as 0.
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, grid.length, 0);
    }

    // Recursively verifies whether the knight follows
    // the correct sequence from 0 to n*n-1.
    public boolean isValid(int[][] grid, int r, int c, int n, int expVal) {

        // Invalid position or incorrect expected value.
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != expVal) {
            return false;
        }

        // All cells have been visited in the correct order.
        if (expVal == n * n - 1) {
            return true;
        }

        // Explore all 8 possible knight moves.
        boolean ans1 = isValid(grid, r - 2, c + 1, n, expVal + 1);
        boolean ans2 = isValid(grid, r - 1, c + 2, n, expVal + 1);
        boolean ans3 = isValid(grid, r + 1, c + 2, n, expVal + 1);
        boolean ans4 = isValid(grid, r + 2, c + 1, n, expVal + 1);
        boolean ans5 = isValid(grid, r + 2, c - 1, n, expVal + 1);
        boolean ans6 = isValid(grid, r + 1, c - 2, n, expVal + 1);
        boolean ans7 = isValid(grid, r - 1, c - 2, n, expVal + 1);
        boolean ans8 = isValid(grid, r - 2, c - 1, n, expVal + 1);

        // Return true if any valid knight path is found.
        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}
