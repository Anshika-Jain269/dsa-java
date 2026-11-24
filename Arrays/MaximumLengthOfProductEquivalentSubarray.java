
# Maximum Length of Product Equivalent Subarray

## Approach

1. Initialize `maxLen` to store the maximum length of a product-equivalent subarray.
2. Use two nested loops to generate all possible contiguous subarrays.
3. For each starting index `i`:
   - Initialize `product = 1`, `g = 0`, and `l = 1`.
4. For each element in the subarray:
   - Update the product by multiplying it with the current element.
   - Calculate the GCD using the `gcd()` method.
   - Calculate the LCM using the `lcm()` method.
5. Check whether the product is equal to `GCD × LCM`.
6. If the condition is satisfied, update `maxLen` with the current subarray length.
7. Return `maxLen`.

## Java Code

```java
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (product == g * l) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
```

## Complexity Analysis

Let `n` be the length of the array.

- **Time Complexity:** O(n² log M) — Two nested loops generate all contiguous subarrays, and GCD/LCM calculations take O(log M) per element, where M is the maximum array value.
- **Space Complexity:** O(1) — Only a constant number of variables are used.

## Key Concepts

- Array Traversal
- Subarrays
- GCD (Greatest Common Divisor)
- LCM (Least Common Multiple)
- Euclidean Algorithm

## Commit Message

`Implement maximum product-equivalent subarray length using GCD and LCM`
