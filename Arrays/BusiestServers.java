
# Find Servers That Handled Most Number of Requests

## Approach
1. Use a `TreeSet` to maintain the indices of available servers in sorted order.
2. Use a Min Heap (Priority Queue) to maintain busy servers based on their finishing times.
3. Initially, add all server indices to the available servers set.
4. For each incoming request:
   - Release all servers whose processing time has finished.
   - Calculate the preferred server index using `i % k`.
   - Use `ceiling()` to find the smallest available server index greater than or equal to the preferred index.
   - If no such server exists, select the smallest available server using `first()`.
5. If no server is available, skip the request.
6. Update the assigned server's request count and add it to the busy servers queue with its finishing time.
7. Find the maximum request count and return all server indices having that count.

## Java Code
```java
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            int server = i % k;
            Integer assigned = available.ceiling(server);

            if (assigned == null) {
                assigned = available.first();
            }

            available.remove(assigned);
            count[assigned]++;

            busy.offer(new int[]{
                arrival[i] + load[i], assigned
            });
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O((n + k) log k), where `n` is the number of requests and `k` is the number of servers. Each request involves TreeSet and PriorityQueue operations.
- **Space Complexity:** O(n + k), for the busy server priority queue, available server set, and request count array.

## Key Concepts
- TreeSet
- Priority Queue (Min Heap)
- Greedy Algorithm
- Simulation
- Ordered Set
```
