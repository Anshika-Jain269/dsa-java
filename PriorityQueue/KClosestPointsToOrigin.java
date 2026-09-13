// Problem: 973. K Closest Points to Origin
//
// Approach:
// 1. Use a Max Heap to store the distance and index of each point.
// 2. Calculate the squared distance from the origin:
//    distance = x² + y²
// 3. Add each point to the PriorityQueue.
// 4. If the heap size becomes greater than k,
//    remove the point with the largest distance.
// 5. At the end, the heap contains the k closest points.
//
// We use squared distance because comparing x² + y²
// gives the same order as comparing the actual distance.
//
// Time Complexity: O(n log k)
// Space Complexity: O(k)

import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max Heap based on distance
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];

            int d1 = x1 * x1 + y1 * y1;

            // Store {distance, index}
            int[] arr = {d1, i};

            pq.add(arr);

            // Keep only k closest points
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        // Get the k closest points
        for (int i = 0; i < k; i++) {

            int[] arr = pq.poll();

            ans[i] = points[arr[1]];
        }

        return ans;
    }
}
