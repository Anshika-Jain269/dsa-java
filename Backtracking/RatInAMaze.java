class Solution {

    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        int n = mat.length;

        // If the starting or destination cell is blocked, no path exists.
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];

        // Start exploring from the top-left cell.
        findPaths(0, 0, mat, visited, "", result);

        return result;
    }

    // Uses backtracking to find all possible paths.
    private void findPaths(int row, int col, int[][] mat,
                           boolean[][] visited, String path,
                           ArrayList<String> result) {

        int n = mat.length;

        // Check boundaries, blocked cells, and already visited cells.
        if (row < 0 || col < 0 || row >= n || col >= n
                || mat[row][col] == 0 || visited[row][col]) {
            return;
        }

        // Destination reached, so store the current path.
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        visited[row][col] = true;

        // Explore all four possible directions.
        findPaths(row + 1, col, mat, visited, path + "D", result);
        findPaths(row, col - 1, mat, visited, path + "L", result);
        findPaths(row, col + 1, mat, visited, path + "R", result);
        findPaths(row - 1, col, mat, visited, path + "U", result);

        // Backtrack so the cell can be used in another path.
        visited[row][col] = false;
    }
}
