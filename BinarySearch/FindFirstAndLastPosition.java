// LeetCode 34 - Find First and Last Position of Element in Sorted Array
//
// Approach:
// 1. Use binary search to find the first occurrence of the target.
// 2. Use another binary search to find the last occurrence.
// 3. For the first occurrence, when target is found, store the index
//    and continue searching in the left half.
// 4. For the last occurrence, when target is found, store the index
//    and continue searching in the right half.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1, last = -1;

        // Find first occurrence
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        // Find last occurrence
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                last = mid;        // Store candidate
                left = mid + 1;    // Continue searching right
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return new int[]{ans, last};
    }
}
