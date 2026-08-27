// LeetCode 162 - Find Peak Element
//
// Approach:
// 1. Use binary search to find a peak element.
// 2. Compare nums[mid] with nums[mid + 1].
// 3. If nums[mid] < nums[mid + 1], the array is increasing,
//    so a peak must exist in the right half.
// 4. Otherwise, a peak exists in the left half or at mid.
// 5. When left == right, we have reached a peak element.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // Peak is in the right half
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }

            // Peak is in the left half or at mid
            else {
                right = mid;
            }
        }

        return left;
    }
}
