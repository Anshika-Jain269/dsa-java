
# Longest Monotonic Subarray

## Approach
1. Maintain three variables:
   - `inc`: Length of the current strictly increasing subarray.
   - `dec`: Length of the current strictly decreasing subarray.
   - `maxLen`: Maximum length found so far.
2. Traverse the array starting from the second element.
3. If the current element is greater than the previous element:
   - Increment `inc`.
   - Reset `dec` to 1.
4. If the current element is smaller than the previous element:
   - Increment `dec`.
   - Reset `inc` to 1.
5. If both elements are equal, reset both `inc` and `dec` to 1.
6. Update `maxLen` after every comparison.
7. Return `maxLen`.

## Java Code
```java
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } 
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } 
            else {
                inc = 1;
                dec = 1;
            }

            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        return maxLen;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n), because the array is traversed once.
- **Space Complexity:** O(1), because only three variables are used.

## Key Concepts
- Array Traversal
- Greedy Approach
- Increasing and Decreasing Subarrays
- Constant Space Optimization
```
