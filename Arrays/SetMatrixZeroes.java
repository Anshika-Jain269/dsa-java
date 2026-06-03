/*
Problem: Set Matrix Zeroes
LeetCode: 73
Difficulty: Medium

Approach:
- Use first row and first column as markers.
- Mark rows and columns that need to be zero.
- Update matrix in-place.

Time Complexity: O(m * n)
Space Complexity: O(1)

Author: Anshika Jain
*/
/*
Problem: Set Matrix Zeroes
LeetCode: 73
Difficulty: Medium

Approach:
- Use first row and first column as markers.
- Mark rows and columns that need to be zero.
- Update matrix in-place.

Time Complexity: O(m * n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)
                firstCol = true;
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0)
                firstRow = true;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 ||
                    matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int j = 0; j < cols; j++)
                matrix[0][j] = 0;
        }

        if (firstCol) {
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;
        }
    }
}
