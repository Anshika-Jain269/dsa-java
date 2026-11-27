
# Maximum Sale Items

## Approach

1. Initialize a DP array of size `budget + 1` to store the maximum number of items that can be selected for each budget.
2. Find the minimum price among all items and store it in `minPrice`.
3. Traverse each item:
   - Extract its `factor` and `price`.
   - Count how many items have a factor divisible by the current item's factor.
   - Use this count as the value associated with the current item's price.
4. Apply **0/1 Knapsack DP**:
   - Traverse the budget from right to left, starting at `budget`.
   - Update `dp[j]` by choosing the maximum between skipping the current item and selecting it.
5. After processing all items, check every possible spending amount:
   - Calculate the remaining budget.
   - Use the remaining budget to purchase additional items at the minimum price.
   - Update the maximum answer.
6. Return the maximum number of items.

## Java Code

```java
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    count++;
                }
            }

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + count);
            }
        }

        int ans = 0;

        for (int i = 0; i <= budget; i++) {
            int extra = (budget - i) / minPrice;
            ans = Math.max(ans, dp[i] + extra);
        }

        return ans;
    }
}
```

## Complexity Analysis

Let:
- `n` = number of items.
- `B` = available budget.

- **Time Complexity:** O(n² + nB + B) — Counting divisible factors takes O(n²), the knapsack transitions take O(nB), and calculating the final answer takes O(B).
- **Space Complexity:** O(B) — The DP array stores results for each possible budget.

## Key Concepts

- Dynamic Programming
- 0/1 Knapsack
- Divisibility
- Array Traversal
- Budget Optimization
