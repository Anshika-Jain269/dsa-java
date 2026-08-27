// LeetCode 153 - Find Minimum in Rotated Sorted Array
//
// Approach:
// 1. Use binary search to find the minimum element.
// 2. Compare nums[mid] with nums[right] to determine which half
//    contains the minimum element.
// 3. If nums[mid] > nums[right], the minimum lies in the right half.
// 4. Otherwise, the minimum lies in the left half, including mid.
// 5. When left == right, nums[left] is the minimum element.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Minimum is in the left half or at mid
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}
