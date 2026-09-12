// Problem: 274. H-Index
//
// Approach:
// 1. Binary search on the possible H-Index from 0 to n.
// 2. For every mid value, count how many papers
//    have at least mid citations.
// 3. If count >= mid, mid is a possible H-Index,
//    so search for a larger value.
// 4. Otherwise, search for a smaller value.
// 5. Return right as the maximum valid H-Index.
//
// Time Complexity: O(n log n)
// Space Complexity: O(1)

class Solution {
    public int hIndex(int[] citations) {

        int left = 0;
        int right = citations.length;

        while (left <= right) {

            int mid = (left + right) / 2;
            int count = 0;

            // Count papers having at least mid citations
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    count++;
                }
            }

            if (count >= mid) {
                // mid is possible, try for a larger H-Index
                left = mid + 1;
            } else {
                // mid is not possible, search smaller values
                right = mid - 1;
            }
        }

        return right;
    }
}
