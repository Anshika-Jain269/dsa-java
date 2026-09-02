import java.util.HashMap;

class Solution {

    /*
     * Problem: Continuous Subarray Sum
     *
     * Approach:
     * We use Prefix Sum + HashMap.
     *
     * If two prefix sums have the same remainder when divided by k,
     * their difference is divisible by k.
     *
     * We store:
     *     remainder -> earliest index where it occurred
     *
     * For the current remainder:
     *     length = currentIndex - previousIndex
     *
     * If length >= 2, we found a valid subarray.
     *
     * Why store the earliest index?
     * Because it gives us the longest possible subarray.
     *
     * We initialize:
     *     remainder 0 -> index -1
     *
     * This handles subarrays starting from index 0.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;

        // Stores remainder -> earliest index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix sum has remainder 0
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            // Calculate prefix sum
            sum += nums[i];

            // Find remainder
            int rem = sum % k;

            // If same remainder appeared before
            if (map.containsKey(rem)) {

                // Calculate subarray length
                int length = i - map.get(rem);

                // Subarray must contain at least 2 elements
                if (length >= 2) {
                    return true;
                }
            } 
            else {
                // Store only the first/earliest occurrence
                map.put(rem, i);
            }
        }

        return false;
    }
}
