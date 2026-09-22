import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> ans = new ArrayList<>();

        // Sort by height in descending order.
        // If heights are equal, sort by k in ascending order.
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });

        // Insert each person at index k
        for (int i = 0; i < people.length; i++) {
            int h = people[i][0];
            int k = people[i][1];

            ans.add(k, new int[]{h, k});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
