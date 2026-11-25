
# Minimum Length of a Unique Subarray

## Approach

1. Calculate the maximum element in the array and use `max + 1` as the base for polynomial rolling hash.
2. Use binary search to find the minimum possible length of a unique subarray.
3. For each candidate length, call the `check()` method:
   - Calculate the rolling hash of each subarray using a sliding window.
   - Store the frequency of each hash in a HashMap.
   - If any hash occurs exactly once, a unique subarray of that length exists.
4. Use rolling hash to update the window efficiently by removing the outgoing element and adding the next element.
5. If a unique subarray exists, store the current length and search for a smaller length.
6. Otherwise, search for a larger length.
7. Return the minimum valid length.

## Java Code

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long findPower(long a, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = findPower(a, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }

    private boolean check(int[] nums, int size, long base) {
        int n = nums.length;
        long hash = 0;

        Map<Long, Integer> mp = new HashMap<>();
        long p = findPower(base % MOD, size - 1);

        int i = 0;
        int j = 0;

        while (j < n) {
            hash = (hash * base + nums[j]) % MOD;

            if (j - i + 1 < size) {
                j++;
            } else {
                mp.put(hash, mp.getOrDefault(hash, 0) + 1);

                hash = (hash - (p * nums[i]) % MOD + MOD) % MOD;

                i++;
                j++;
            }
        }

        for (int count : mp.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        long base = Arrays.stream(nums).max().getAsInt() + 1L;

        int l = 1;
        int r = n;
        int result = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(nums, mid, base)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}
```

## Complexity Analysis

Let `n` be the length of the array.

- **Time Complexity:** O(n log n) expected — Binary search performs O(log n) checks. Each check processes O(n) windows and uses HashMap operations that take O(1) expected time.
- **Space Complexity:** O(n) — The HashMap stores the frequencies of the subarray hashes.

## Key Concepts

- Binary Search on Answer
- Sliding Window
- Polynomial Rolling Hash
- HashMap
- Modular Arithmetic
- Fast Exponentiation
