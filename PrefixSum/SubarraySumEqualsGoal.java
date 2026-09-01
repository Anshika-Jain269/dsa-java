import java.util.HashMap;

class Solution {

    /*
     * Problem: Binary Subarrays With Sum
     *
     * Approach:
     * We use Prefix Sum + HashMap.
     *
     * Let sum be the prefix sum up to the current element.
     *
     * If we want a subarray with sum = goal:
     *
     *     currentSum - previousSum = goal
     *
     * Therefore:
     *
     *     previousSum = currentSum - goal
     *
     * We store the frequency of every prefix sum in the HashMap.
     * Whenever (sum - goal) exists in the map, its frequency tells
     * us how many subarrays ending at the current index have sum = goal.
     *
     * We initially store:
     *
     *     map.put(0, 1)
     *
     * This handles subarrays whose sum is exactly equal to goal
     * from the beginning of the array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int sum = 0;

        // Stores prefix sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix with sum 0
        map.put(0, 1);

        for (int num : nums) {

            // Calculate current prefix sum
            sum += num;

            // Check if a previous prefix sum can form the required goal
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }

            // Store/update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
