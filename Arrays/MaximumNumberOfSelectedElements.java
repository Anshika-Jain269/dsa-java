
# Maximum Number of Selected Elements in an Array

## Approach

1. Sort the array in ascending order to process elements in a suitable order.
2. Use a `HashMap` named `dp` to store the maximum length of a consecutive sequence ending at a particular value.
3. For each element `nums[i]`, consider two possibilities:
   - **Increase the element by 1:** Extend the sequence ending at `nums[i]` and store the result at `nums[i] + 1`.
   - **Keep the element unchanged:** Extend the sequence ending at `nums[i] - 1` and store the result at `nums[i]`.
4. Update the values in the HashMap using the maximum of the existing and newly calculated lengths.
5. Update `ans` with the maximum sequence length found.
6. Return `ans`.

## Java Code

```java
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            // Option 1: Increase the element by 1
            int next = dp.getOrDefault(nums[i], 0) + 1;

            // Option 2: Keep the element unchanged
            int current = dp.getOrDefault(nums[i] - 1, 0) + 1;

            dp.put(nums[i] + 1, Math.max(
                dp.getOrDefault(nums[i] + 1, 0), next
            ));

            dp.put(nums[i], Math.max(
                dp.getOrDefault(nums[i], 0), current
            ));

            ans = Math.max(ans, Math.max(
                dp.get(nums[i]), dp.get(nums[i] + 1)
            ));
        }

        return ans;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n log n) — Sorting takes O(n log n), and processing each element with HashMap operations takes O(n) on average.
- **Space Complexity:** O(n) — The HashMap can store up to O(n) distinct values.

## Key Concepts

- Array Sorting
- Dynamic Programming
- HashMap
- Consecutive Sequence
