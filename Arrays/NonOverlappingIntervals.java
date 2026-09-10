// Problem: 435. Non-overlapping Intervals
//
// Approach:
// 1. Sort intervals according to their ending time.
// 2. Keep track of the end of the last selected interval.
// 3. If the current interval starts after or at the last end,
//    it does not overlap, so we keep it.
// 4. Otherwise, it overlaps, so we remove it.
//
// Time Complexity: O(n log n)
// Space Complexity: O(1) (excluding sorting space)

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort by ending time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // No overlap
            if (intervals[i][0] >= lastEnd) {
                lastEnd = intervals[i][1];
            }
            // Overlap
            else {
                count++;
            }
        }

        return count;
    }
}
