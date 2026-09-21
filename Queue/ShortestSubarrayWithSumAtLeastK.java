import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefix = new long[nums.length + 1];
        Deque<Integer> dq = new LinkedList<>();

        // Build prefix sum array
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = nums.length + 1;

        for (int i = 0; i <= nums.length; i++) {

            // Check if current subarray has sum >= k
            while (!dq.isEmpty() &&
                   prefix[i] - prefix[dq.peekFirst()] >= k) {

                ans = Math.min(ans, i - dq.pollFirst());
            }

            // Maintain increasing prefix sums in deque
            while (!dq.isEmpty() &&
                   prefix[dq.peekLast()] >= prefix[i]) {

                dq.pollLast();
            }

            dq.addLast(i);
        }

        return ans == nums.length + 1 ? -1 : ans;
    }
}
