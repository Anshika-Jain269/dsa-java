
# Minimum Operations to Make K Subarrays Equal

## Approach
1. Use dynamic programming to find the minimum cost of selecting exactly `k` non-overlapping subarrays of size `x`.
2. For each subarray, sort its elements and find the median.
3. Calculate the cost of making all elements equal to the median using the sum of absolute differences.
4. Use `dp[i][j]` to represent the minimum operations needed to select `j` valid subarrays from the first `i` elements.
5. Either skip the current element or select a subarray ending at `i`.

## Java Code
```java
import java.util.Arrays;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = x; i <= n; i++) {
            int[] a = Arrays.copyOfRange(nums, i - x, i);
            Arrays.sort(a);

            int mid = a[x / 2];
            long cost = 0;

            for (int v : a) {
                cost += Math.abs((long) v - mid);
            }

            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                dp[i][j] = Math.min(
                    dp[i][j],
                    dp[i - x][j - 1] + cost
                );
            }
        }

        return dp[n][k];
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n × x log x + n × k)
  - Sorting each subarray takes O(x log x).
  - The DP transitions take O(n × k).

- **Space Complexity:** O(n × k + x)
  - The DP table requires O(n × k) space.
  - The temporary subarray requires O(x) space.
