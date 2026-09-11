// Problem: 1046. Last Stone Weight
//
// Approach:
// 1. Store all stones in a Max Heap using PriorityQueue.
// 2. Take the two heaviest stones.
// 3. If they are equal, both are destroyed.
// 4. Otherwise, add the difference back into the heap.
// 5. Continue until at most one stone remains.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the PriorityQueue
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        // Smash the two heaviest stones
        while (pq.size() >= 2) {

            int x = pq.poll();
            int y = pq.poll();

            if (x != y) {
                pq.add(x - y);
            }
        }

        // No stones left
        if (pq.size() == 0) {
            return 0;
        }

        // Return the remaining stone
        return pq.peek();
    }
}
