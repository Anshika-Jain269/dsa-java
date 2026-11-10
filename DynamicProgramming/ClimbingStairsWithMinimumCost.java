
# Climbing Stairs with Minimum Cost

## Approach
1. Use a DP array where `dp[i]` represents the minimum cost required to reach stair `i`.
2. Initialize `dp[0] = 0` because no cost is required to remain at the ground level.
3. For each stair `i`, consider three possible jumps:
   - **1-step jump:** `dp[i-1] + costs[i-1] + 1`
   - **2-step jump:** `dp[i-2] + costs[i-1] + 4`
   - **3-step jump:** `dp[i-3] + costs[i-1] + 9`
4. Take the minimum among all valid transitions.
5. Return `dp[n]` as the minimum total cost to reach the destination.

## Java Code
```java
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = costs[i - 1] + dp[i - 1] + 1;

            if (i >= 2) {
                dp[i] = Math.min(
                    dp[i],
                    dp[i - 2] + costs[i - 1] + 4
                );
            }

            if (i >= 3) {
                dp[i] = Math.min(
                    dp[i],
                    dp[i - 3] + costs[i - 1] + 9
                );
            }
        }

        return dp[n];
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n), because each stair is processed once with at most three transitions.
- **Space Complexity:** O(n), for the DP array.

## Key Concepts
- Dynamic Programming
- Bottom-Up Approach
- Recurrence Relation
- Space Optimization
```
