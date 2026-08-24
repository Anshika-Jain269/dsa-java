class Solution {

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Directions for all 8 neighboring cells.
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int liveNeighbors = 0;

                // Count the live neighboring cells.
                for (int k = 0; k < 8; k++) {

                    int row = i + dr[k];
                    int col = j + dc[k];

                    // Skip cells outside the board.
                    if (row < 0 || row >= rows || col < 0 || col >= cols) {
                        continue;
                    }

                    // 1 = currently alive
                    // 2 = currently alive but will become dead
                    if (board[row][col] == 1 || board[row][col] == 2) {
                        liveNeighbors++;
                    }
                }

                // A live cell dies due to underpopulation or overpopulation.
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                }

                // A dead cell becomes alive with exactly 3 live neighbors.
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3;
                }
            }
        }

        // Convert temporary states into their final states.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // 2: alive -> dead
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }

                // 3: dead -> alive
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
