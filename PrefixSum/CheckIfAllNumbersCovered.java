// Problem: Check if Every Number in a Range Is Covered
//
// Approach:
// For every number from left to right, check whether there is
// at least one range that contains that number.
// If any number is not covered, return false.
// Otherwise, return true.
//
// Time Complexity: O((right - left + 1) * n)
// Space Complexity: O(1)

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {

        for (int i = left; i <= right; i++) {

            boolean covered = false;

            for (int j = 0; j < ranges.length; j++) {

                if (ranges[j][0] <= i && i <= ranges[j][1]) {
                    covered = true;
                    break;
                }
            }

            if (!covered) {
                return false;
            }
        }

        return true;
    }
}
