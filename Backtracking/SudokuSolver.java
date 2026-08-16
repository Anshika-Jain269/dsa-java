class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Uses backtracking to fill all empty cells.
    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Find an empty cell.
                if (board[row][col] == '.') {

                    // Try numbers from 1 to 9.
                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, row, col, num)) {

                            // Place the number.
                            board[row][col] = num;

                            // Recursively solve the remaining board.
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if the choice leads to no solution.
                            board[row][col] = '.';
                        }
                    }

                    // No valid number can be placed in this cell.
                    return false;
                }
            }
        }

        // No empty cells remain, so the Sudoku is solved.
        return true;
    }

    // Checks whether a number can be safely placed in a cell.
    private boolean isSafe(char[][] board, int row, int col, char number) {

        // Check the current row.
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == number) {
                return false;
            }
        }

        // Check the current column.
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == number) {
                return false;
            }
        }

        // Find the starting position of the 3x3 box.
        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;

        // Check the 3x3 box.
        for (int r = boxStartRow; r < boxStartRow + 3; r++) {
            for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}
