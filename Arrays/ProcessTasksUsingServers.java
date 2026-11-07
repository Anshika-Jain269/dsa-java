
# Process Tasks Using Servers

## Approach
1. Use two Priority Queues to manage servers:
   - `freeServers`: Stores available servers based on weight and index.
   - `busyServers`: Stores busy servers based on their finishing time, weight, and index.
2. Initially, add all servers to the free servers priority queue.
3. Iterate through the tasks in their given order.
4. Move all servers whose processing time has finished into the free servers queue.
5. If a free server is available, select the server with the smallest weight. If weights are equal, choose the server with the smallest index.
6. If no server is available, select the server that finishes earliest and assign the current task after it becomes available.
7. Store the assigned server index in the result array.

## Java Code
```java
import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1])
        );

        PriorityQueue<long[]> busyServers = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            freeServers.add(new int[]{servers[i], i});
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                long[] cur = busyServers.poll();
                freeServers.add(new int[]{(int) cur[1], (int) cur[2]});
            }

            if (freeServers.isEmpty()) {
                long[] cur = busyServers.poll();

                result[i] = (int) cur[2];

                busyServers.add(new long[]{
                    cur[0] + tasks[i], cur[1], cur[2]
                });
            } else {
                int[] cur = freeServers.poll();

                result[i] = cur[1];

                busyServers.add(new long[]{
                    (long) i + tasks[i], cur[0], cur[1]
                });
            }
        }

        return result;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O((n + m) log n), where `n` is the number of servers and `m` is the number of tasks. Each server and task involves priority queue operations.
- **Space Complexity:** O(n + m), including the priority queues and result array.

## Key Concepts
- Priority Queue
- Min Heap
- Greedy Algorithm
- Simulation
```
