// Problem: 1943. Describe the Painting
//
// Approach:
// 1. Use a difference array to store changes in color at each position.
// 2. At the start of a segment, add its color.
// 3. At the end of a segment, subtract its color.
// 4. Use prefix sum to find the total color at each position.
// 5. Whenever the color sum is greater than 0, create a painted segment.
//
// Time Complexity: O(n + m)
// Space Complexity: O(m)
//
// n = number of segments
// m = maximum endpoint

import java.util.*;

class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {

        List<List<Long>> ans = new ArrayList<>();

        long[] color = new long[100002];

        for (int i = 0; i < segments.length; i++) {
            int start = segments[i][0];
            int end = segments[i][1];
            int paint = segments[i][2];

            color[start] += paint;
            color[end] -= paint;
        }

        long currentColor = 0;
        int start = 0;

        for (int i = 1; i < color.length; i++) {

            currentColor += color[i];

            if (currentColor != 0) {

                if (color[i] != 0 && start != 0) {
                    ans.add(Arrays.asList(
                        (long) start,
                        (long) i,
                        currentColor - color[i]
                    ));
                    start = i;
                }

                if (start == 0) {
                    start = i;
                }
            } else {
                if (start != 0) {
                    ans.add(Arrays.asList(
                        (long) start,
                        (long) i,
                        currentColor
                    ));
                    start = 0;
                }
            }
        }

        return ans;
    }
}
