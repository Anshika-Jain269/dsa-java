/*
 * Problem: Create Grid
 *
 * Approach:
 * 1. Create a String array to store m rows.
 * 2. For each row, create a character array of length n.
 * 3. Fill the cell with '.' if it belongs to the first row
 *    or the last column.
 * 4. Fill all other cells with '#'.
 * 5. Convert each character array into a String and store it.
 * 6. Return the completed grid.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public String[] createGrid(int m, int n) {
        String[] arr = new String[m];

        // Create each row of the grid
        for (int i = 0; i < m; i++) {
            char[] row = new char[n];

            // Fill each column in the current row
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    row[j] = '.';
                } else {
                    row[j] = '#';
                }
            }

            // Convert the character array into a String
            arr[i] = new String(row);
        }

        return arr;
    }
}
