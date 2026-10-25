/*
 * Problem: LeetCode 278 - First Bad Version
 *
 * Approach:
 * 1. Initialize the search range from version 1 to n.
 * 2. Calculate the middle version safely using:
 *    mid = left + (right - left) / 2.
 * 3. If mid is bad, search the left half, including mid.
 * 4. If mid is good, search the right half starting from mid + 1.
 * 5. When left == right, that version is the first bad version.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version);
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // Calculate the middle without risking integer overflow
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid may be the first bad version
                right = mid;
            } else {
                // The first bad version must be after mid
                left = mid + 1;
            }
        }

        // left and right converge to the first bad version
        return left;
    }
}
