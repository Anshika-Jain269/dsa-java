
# Minimum Changes to Make K Semi-palindromes

## Approach

### 1. Precompute Substring Costs
- Create a 2D array `cost[i][j]` to store the minimum changes required to make the substring `s[i...j]` a semi-palindrome.
- Consider every substring with length at least 2.
- Check all possible divisors `d` of the substring length.
- Divide the substring into groups based on positions modulo `d`.
- Compare symmetric characters within each group.
- Increment the change count whenever two symmetric characters differ.
- Store the minimum change count among all valid divisors.

### 2. Dynamic Programming
- Define `dp[i][parts]` as the minimum changes required to divide the first `i` characters into exactly `parts` semi-palindromic substrings.
- Initialize all states with infinity and set `dp[0][0] = 0`.
- Try every valid starting position for the last substring.
- Update the DP state using:

  `dp[i][parts] = min(dp[i][parts], dp[start][parts-1] + cost[start][i-1])`

- Return `dp[n][k]` as the minimum number of changes required.

## Java Code
```java
import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int r = 0; r < d; r++) {
                        int left = i + r;
                        int right = i + r + ((len - 1 - r) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        int INF = 1_000_000_000;

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int parts = 1; parts <= k; parts++) {
                for (int start = 0; start <= i - 2; start++) {
                    if (dp[start][parts - 1] == INF) {
                        continue;
                    }

                    dp[i][parts] = Math.min(
                        dp[i][parts],
                        dp[start][parts - 1] + cost[start][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n⁴ + kn²), where `n` is the length of the string and `k` is the required number of partitions.
  - Substring cost precomputation takes O(n⁴) in the worst case.
  - DP transitions take O(kn²).

- **Space Complexity:** O(n² + nk).
  - Cost matrix: O(n²).
  - DP table: O(nk).

## Key Concepts
- Dynamic Programming
- String Manipulation
- Substring Processing
- Divisor Enumeration
- Palindrome Checking
- Partition DP
```
