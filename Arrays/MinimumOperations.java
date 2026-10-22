/*
 * Problem: Minimum Operations
 *
 * Approach:
 * 1. If the array contains only one element, return 0.
 * 2. Count descending transitions in the circular array.
 * 3. Reverse the array and count descending transitions again.
 * 4. If either count equals 1, find the index of 0 and
 *    calculate the possible operations.
 * 5. Return the minimum valid operation count.
 * 6. If neither case is valid, return -1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // A single-element array needs no operations
        if (n == 1) {
            return 0;
        }

        int count = 0;

        // Count descending transitions in the circular array
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // Create the reversed array
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[n - 1 - i];
        }

        int count1 = 0;

        // Count descending transitions in the reversed array
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count1++;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Calculate operations for the original array
        if (count == 1) {
            int index = 0;

            // Find the position of 0
            while (nums[index] != 0) {
                index++;
            }

            ans = Math.min(index, n - index + 2);
        }

        // Calculate operations for the reversed array
        if (count1 == 1) {
            int index = 0;

            // Find the position of 0
            while (arr[index] != 0) {
                index++;
            }

            ans = Math.min(ans, 1 + Math.min(index, n - index));
        }

        // Return -1 if no valid case was found
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
