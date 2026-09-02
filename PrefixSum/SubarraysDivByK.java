import java.util.HashMap;

class Solution {

    /*
     * Problem: Subarray Sums Divisible by K
     *
     * Approach:
     * We use Prefix Sum + HashMap.
     *
     * If two prefix sums have the same remainder when divided by k,
     * their difference is divisible by k.
     *
     * Suppose:
     *
     *     prefixSum[j] % k == prefixSum[i] % k
     *
     * Then:
     *
     *     (prefixSum[j] - prefixSum[i]) % k == 0
     *
     * So, we store the frequency of each remainder in a HashMap.
     *
     * For the current prefix sum, if the same remainder has already
     * appeared, every previous occurrence forms a valid subarray.
     *
     * Important:
     * In Java, the % operator can return a negative value.
     * For example:
     *
     *     -2 % 5 = -2
     *
     * We need a positive remainder between 0 and k - 1, so we use:
     *
     *     ((sum % k) + k) % k
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */

    public int subarraysDivByK(int[] nums, int k) {

        int count = 0;
        int sum = 0;

        // Stores remainder and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix has remainder 0
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // Calculate prefix sum
            sum += nums[i];

            // Convert negative remainder into a positive remainder
            int remainder = ((sum % k) + k) % k;

            // Same remainder means the subarray sum is divisible by k
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            // Store/update frequency of the current remainder
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
