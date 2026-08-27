// LeetCode 704 - Binary Search
//
// Approach:
// 1. Use binary search because the array is sorted.
// 2. Find the middle element.
// 3. If nums[mid] is equal to target, return mid.
// 4. If nums[mid] is greater than target, search in the left half.
// 5. Otherwise, search in the right half.
// 6. If the target is not found, return -1.
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
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
