/*
Problem: Container With Most Water
LeetCode: 11
Difficulty: Medium

Approach:
- Use two pointers, one at the beginning and one at the end.
- Calculate the area formed by the two lines.
- Move the pointer with the smaller height inward.
- Keep track of the maximum area.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
