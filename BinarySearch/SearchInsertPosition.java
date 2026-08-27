// LeetCode 35 - Search Insert Position
//
// Approach:
// 1. Use binary search because the array is sorted.
// 2. If the target is found, return its index.
// 3. If nums[mid] is smaller than the target, search in the right half.
// 4. Otherwise, search in the left half.
// 5. When the loop ends, 'left' represents the correct position
//    where the target should be inserted.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return left;
    }
}
