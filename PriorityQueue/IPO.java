// Problem: 502. IPO
//
// Approach:
// 1. Store projects as [capital, profit].
// 2. Sort projects based on required capital.
// 3. For every project we can currently afford, add its profit
//    into a max PriorityQueue.
// 4. Select the project with maximum profit.
// 5. Add that profit to our current capital.
// 6. Repeat at most k times.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Store [capital, profit]
        int[][] projects = new int[profits.length][2];

        for (int i = 0; i < profits.length; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects according to required capital
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        // Max Heap: stores profits
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        int index = 0;

        // We can select at most k projects
        for (int i = 0; i < k; i++) {

            // Add all projects that we can currently afford
            while (index < projects.length &&
                   projects[index][0] <= w) {

                pq.add(projects[index][1]);
                index++;
            }

            // No project can be completed
            if (pq.isEmpty()) {
                break;
            }

            // Select project with maximum profit
            w += pq.poll();
        }

        return w;
    }
}
