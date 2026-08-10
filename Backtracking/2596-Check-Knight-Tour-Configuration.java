```java
class Solution {

    public boolean checkValidGrid(int[][] grid) {

        // Start from (0,0), expected value is 0
        return isValid(grid, 0, 0, grid.length, 0);
    }

    public boolean isValid(int[][] grid, int r, int c, int n, int expVal) {

        // Check boundary and whether the current cell
        // contains the expected value
        if (r < 0 || r >= n || c < 0 || c >= n ||
            grid[r][c] != expVal) {
            return false;
        }

        // If we reached the last value, the knight tour is valid
        if (expVal == n * n - 1) {
            return true;
        }

        // Try all 8 possible moves of a knight

        // Move: 2 rows up, 1 column right
        boolean ans1 = isValid(grid, r - 2, c + 1, n, expVal + 1);

        // Move: 1 row up, 2 columns right
        boolean ans2 = isValid(grid, r - 1, c + 2, n, expVal + 1);

        // Move: 1 row down, 2 columns right
        boolean ans3 = isValid(grid, r + 1, c + 2, n, expVal + 1);

        // Move: 2 rows down, 1 column right
        boolean ans4 = isValid(grid, r + 2, c + 1, n, expVal + 1);

        // Move: 2 rows down, 1 column left
        boolean ans5 = isValid(grid, r + 2, c - 1, n, expVal + 1);

        // Move: 1 row down, 2 columns left
        boolean ans6 = isValid(grid, r + 1, c - 2, n, expVal + 1);

        // Move: 1 row up, 2 columns left
        boolean ans7 = isValid(grid, r - 1, c - 2, n, expVal + 1);

        // Move: 2 rows up, 1 column left
        boolean ans8 = isValid(grid, r - 2, c - 1, n, expVal + 1);

        // If any of the 8 possible moves gives a valid tour,
        // return true
        return ans1 || ans2 || ans3 || ans4 ||
               ans5 || ans6 || ans7 || ans8;
    }
}
```
