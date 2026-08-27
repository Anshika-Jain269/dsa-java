// LeetCode 33 - Search in Rotated Sorted Array
//
// Approach:
// 1. Use binary search.
// 2. At every step, check which half of the array is sorted.
// 3. If the target lies in the sorted half, search there.
// 4. Otherwise, search in the other half.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
