
# Count Servers That Received Requests

## Approach
1. Sort the logs based on their timestamps to process requests in chronological order.
2. Store each query along with its original index and sort them by query time.
3. Use two pointers (`i` and `j`) to maintain the current time window `[query - x, query]`.
4. Use a HashMap to maintain the frequency of requests received by each server within the current window.
5. Expand the window by adding logs whose timestamps are less than or equal to the query time.
6. Remove logs that fall outside the window by decreasing their server frequency.
7. The number of servers that did not receive any requests is `n - mp.size()`.
8. Store each answer at its original query index and return the result.

## Java Code
```java
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int q = queries.length;
        int[][] timeIndex = new int[q][2];

        for (int i = 0; i < q; i++) {
            timeIndex[i][0] = queries[i];
            timeIndex[i][1] = i;
        }

        Arrays.sort(timeIndex, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[q];

        int i = 0, j = 0;

        for (int[] pair : timeIndex) {
            int curtime = pair[0];
            int ind = pair[1];

            int start = curtime - x;
            int end = curtime;

            while (j < m && logs[j][1] <= end) {
                int serverId = logs[j][0];
                mp.put(serverId, mp.getOrDefault(serverId, 0) + 1);
                j++;
            }

            while (i < m && logs[i][1] < start) {
                int serverId = logs[i][0];

                mp.put(serverId, mp.get(serverId) - 1);

                if (mp.get(serverId) == 0) {
                    mp.remove(serverId);
                }

                i++;
            }

            result[ind] = n - mp.size();
        }

        return result;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(L log L + Q log Q), where L is the number of logs and Q is the number of queries. Sorting takes O(L log L + Q log Q), while the sliding window processes each log at most twice.
- **Space Complexity:** O(L + Q), for the sorted query-index array, result array, and HashMap.

## Key Concepts
- Sorting
- Sliding Window
- Two Pointers
- HashMap
