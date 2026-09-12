// Problem: 373. Find K Pairs with Smallest Sums
//
// Approach:
// 1. Use a Min Heap to store the pairs with the smallest sums.
// 2. Initially, add pairs using the first element of nums1.
// 3. Remove the pair with the smallest sum.
// 4. Add the next possible pair from nums2.
// 5. Continue until we get k pairs.
//
// Time Complexity: O(k log k)
// Space Complexity: O(k)

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (j + 1 < nums2.length) {
                pq.add(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return result;
    }
}
