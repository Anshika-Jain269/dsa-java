
# Maximum Sale Items

## Approach

1. **Frequency Calculation:**
   - Create a frequency array to count how many items have each factor.
   - Find the minimum price among all items.

2. **Count Multiples:**
   - Create a `multiples` array.
   - For each factor `i`, count how many item factors are divisible by `i`.
   - This helps calculate the additional gain obtained by selecting an item.

3. **Generate Candidates:**
   - For each item, calculate its gain as `multiples[factor] - 1`.
   - Consider only items with positive gain and price at most twice the minimum price.
   - Store the price and gain in the candidates array.

4. **Sort Candidates:**
   - Sort the candidates in ascending order of price.

5. **Greedy Selection:**
   - Traverse the sorted candidates.
   - Calculate how many times each candidate can be purchased within the remaining budget.
   - Add twice the purchased quantity to the answer.
   - Update the remaining budget.

6. **Purchase Remaining Items:**
   - Use the remaining budget to purchase items at the minimum price.
   - Return the total maximum count.

## Java Code

```java
import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] multiples = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                multiples[i] += freq[j];
            }
        }

        long[][] candidates = new long[n][2];
        int size = 0;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = multiples[factor] - 1;

            if (gain > 0 && price <= 2L * minPrice) {
                candidates[size][0] = price;
                candidates[size][1] = gain;
                size++;
            }
        }

        Arrays.sort(candidates, 0, size,
            (a, b) -> Long.compare(a[0], b[0]));

        long remaining = budget;
        long ans = 0;

        for (int i = 0; i < size; i++) {
            long price = candidates[i][0];
            long gain = candidates[i][1];

            long buy = Math.min(gain, remaining / price);

            ans += 2 * buy;
            remaining -= buy * price;
        }

        ans += remaining / minPrice;

        return (int) ans;
    }
}
```

## Complexity Analysis

Let `n` be the number of items and `B` be the budget.

- **Time Complexity:** O(n log n) — Frequency calculation takes O(n), counting multiples takes O(n log n), candidate sorting takes O(n log n), and greedy selection takes O(n).
- **Space Complexity:** O(n) — Frequency array, multiples array, and candidates array require O(n) space.

## Key Concepts

- Greedy Algorithm
- Frequency Counting
- Divisibility and Multiples
- Sorting
- Budget Optimization
