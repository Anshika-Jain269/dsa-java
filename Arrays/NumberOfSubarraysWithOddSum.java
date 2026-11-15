
# Number of Subarrays with Odd Sum

## Approach
1. Initialize `odd = 0` and `even = 1` to count odd and even prefix XOR values. The initial prefix XOR is `0`, which is even.
2. Maintain a variable `prefix` to calculate the parity of the current prefix sum using XOR.
3. Traverse the array and update the prefix parity using `prefix ^= (arr[i] & 1)`.
4. If the current prefix parity is odd (`1`):
   - Add the number of previous even prefixes to the answer because an even prefix combined with an odd prefix produces an odd subarray sum.
   - Increment `odd`.
5. Otherwise:
   - Add the number of previous odd prefixes because an odd prefix combined with an even prefix produces an odd subarray sum.
   - Increment `even`.
6. Apply modulo `10^9 + 7` to prevent overflow.
7. Return the final count.

## Java Code
```java
class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int odd = 0;
        int even = 1;
        int prefix = 0;
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix ^= (arr[i] & 1);

            if (prefix == 1) {
                count += even;
                odd++;
            } else {
                count += odd;
                even++;
            }

            count %= mod;
        }

        return (int) count;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n), because the array is traversed once.
- **Space Complexity:** O(1), because only a constant number of variables are used.

## Key Concepts
- Prefix XOR
- Prefix Sum Parity
- Counting
- Modular Arithmetic
```
