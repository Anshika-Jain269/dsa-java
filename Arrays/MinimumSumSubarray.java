
# Minimum Sum of a Subarray of Size Between L and R

## Approach
1. Initialize `minsum` with `Integer.MAX_VALUE` to track the minimum positive subarray sum.
2. Use two nested loops to generate all possible contiguous subarrays.
3. For each starting index, initialize the running sum to zero.
4. Extend the subarray by adding elements one by one and update the running sum.
5. Calculate the current subarray length.
6. If the length is between `l` and `r` (inclusive) and the sum is positive, update `minsum`.
7. If no valid subarray is found, return `-1`; otherwise, return the minimum sum.

## Java Code
```java
import java.util.List;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minsum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;

            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);

                int len = j - i + 1;

                if (len >= l && len <= r && sum > 0) {
                    minsum = Math.min(minsum, sum);
                }
            }
        }

        return minsum == Integer.MAX_VALUE ? -1 : minsum;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n²), where `n` is the size of the list, because we generate all possible contiguous subarrays.
- **Space Complexity:** O(1), because only a constant number of extra variables are used.

## Key Concepts
- Array Traversal
- Nested Loops
- Subarray
- Running Sum
- Minimum Value Tracking
```
