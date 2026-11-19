
# Minimize Sum

## Approach

1. Sort the array in ascending order.
2. Since we can modify at most three elements, consider the three possible ways to minimize the difference between the maximum and minimum remaining values:
   - Remove the three smallest elements: `nums[n - 1] - nums[2]`.
   - Remove the two smallest and the largest element: `nums[n - 2] - nums[1]`.
   - Remove the two largest and the smallest element: `nums[n - 3] - nums[0]`.
3. Calculate all three possible differences.
4. Return the minimum among them.

## Java Code

```java
import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int first = nums[n - 1] - nums[2];
        int second = nums[n - 2] - nums[1];
        int third = nums[n - 3] - nums[0];

        return Math.min(first, Math.min(second, third));
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n log n) — Sorting the array takes O(n log n), while calculating the three differences takes O(1).
- **Space Complexity:** O(1) auxiliary space, excluding the internal space used by the sorting implementation.

## Key Concepts

- Array Sorting
- Greedy Approach
- Case Analysis
