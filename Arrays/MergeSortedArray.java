/*
Problem: Merge Sorted Array
LeetCode: 88
Difficulty: Easy

Approach:
- Use three pointers:
  1. i -> last element of nums1's valid elements
  2. j -> last element of nums2
  3. k -> last position of nums1
- Compare elements from the end and place the larger one at position k.
- Continue until all elements of nums2 are merged.

Time Complexity: O(m + n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;      // Last valid element in nums1
        int j = n - 1;      // Last element in nums2
        int k = m + n - 1;  // Last position in nums1

        // Merge from the end
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining elements of nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
