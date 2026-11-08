
# Count Servers that Communicate

## Approach
1. Initialize two arrays to store the number of servers in each row and column.
2. Traverse the grid and count the servers (`1`) present in every row and column.
3. Traverse the grid again and check each server.
4. A server can communicate if there is at least one other server in the same row or column.
5. If `rowcount[i] > 1` or `colscount[j] > 1`, increment the answer.
6. Return the total count of communicating servers.

## Java Code
```java
class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[] rowcount = new int[m];
        int[] colscount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowcount[i]++;
                    colscount[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 &&
                    (rowcount[i] > 1 || colscount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(m × n), as the grid is traversed twice.
- **Space Complexity:** O(m + n), for the row and column count arrays.

## Key Concepts
- 2D Array
- Matrix Traversal
- Row and Column Counting
```
