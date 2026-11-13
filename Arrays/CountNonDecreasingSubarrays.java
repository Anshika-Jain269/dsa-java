
# Count Non-Decreasing Subarrays

## Approach
1. Use a sliding window with two pointers, `left` and `right`, to maintain a valid subarray.
2. Traverse the array from right to left.
3. Use a monotonic deque to maintain maximum values and their frequencies within the window.
4. Maintain two variables:
   - `sumMax`: Sum of the adjusted non-decreasing elements.
   - `sum`: Sum of the original elements in the current window.
5. When adding a new element:
   - Remove smaller or equal elements from the front of the deque.
   - Merge their frequencies with the current element.
   - Update `sumMax` and `sum`.
6. Calculate the minimum operations required using `sumMax - sum`.
7. If the required operations exceed `k`, shrink the window from the right and update the deque and sums.
8. Add `right - left + 1` to the answer because all valid subarrays starting at the current `left` are counted.

## Java Code
```java
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long sumMax = 0;
        long sum = 0;
        long ans = 0;

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {
            int x = nums[left];
            int count = 1;

            while (!dq.isEmpty() && dq.peekFirst()[0] <= x) {
                int[] curr = dq.pollFirst();

                sumMax -= (long) curr[0] * curr[1];
                count += curr[1];
            }

            dq.offerFirst(new int[]{x, count});

            sumMax += (long) x * count;
            sum += x;

            while (sumMax - sum > k) {
                sum -= nums[right];

                int[] curr = dq.peekLast();
                sumMax -= curr[0];

                curr[1]--;

                if (curr[1] == 0) {
                    dq.pollLast();
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n), because each element is inserted into and removed from the deque at most once.
- **Space Complexity:** O(n), in the worst case, for the monotonic deque.

## Key Concepts
- Sliding Window
- Two Pointers
- Monotonic Deque
- Greedy
- Prefix/Suffix Window Processing
```
