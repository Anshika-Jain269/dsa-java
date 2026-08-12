class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // Initialize the chessboard with empty cells.
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens from the first column.
        backtrack(0, board, result);

        return result;
    }

    // Try to place one queen in each column using backtracking.
    private void backtrack(int col, char[][] board, List<List<String>> result) {

        // All queens have been successfully placed.
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        // Try placing the queen in every row of the current column.
        for (int row = 0; row < board.length; row++) {

            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';

                // Move to the next column.
                backtrack(col + 1, board, result);

                // Backtrack and remove the queen.
                board[row][col] = '.';
            }
        }
    }

    // Checks whether a queen can be safely placed at (row, col).
    private boolean isSafe(char[][] board, int row, int col) {

        // Check the same row.
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal.
        for (int i = row, j = col;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the lower-left diagonal.
        for (int i = row, j = col;
             i < board.length && j >= 0;
             i++, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Converts the character board into the required list of strings.
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }
}class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // Initialize the chessboard with empty cells.
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens from the first column.
        backtrack(0, board, result);

        return result;
    }

    // Try to place one queen in each column using backtracking.
    private void backtrack(int col, char[][] board, List<List<String>> result) {

        // All queens have been successfully placed.
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        // Try placing the queen in every row of the current column.
        for (int row = 0; row < board.length; row++) {

            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';

                // Move to the next column.
                backtrack(col + 1, board, result);

                // Backtrack and remove the queen.
                board[row][col] = '.';
            }
        }
    }

    // Checks whether a queen can be safely placed at (row, col).
    private boolean isSafe(char[][] board, int row, int col) {

        // Check the same row.
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal.
        for (int i = row, j = col;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the lower-left diagonal.
        for (int i = row, j = col;
             i < board.length && j >= 0;
             i++, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Converts the character board into the required list of strings.
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }
}
