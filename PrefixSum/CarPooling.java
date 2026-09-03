class Solution {

    /*
     * Problem: Car Pooling
     *
     * Approach:
     * We use a Difference Array + Prefix Sum.
     *
     * For every trip:
     * - Add passengers at the starting location.
     * - Remove passengers at the ending location.
     *
     * Then, by taking the prefix sum of the array,
     * we get the number of passengers currently in the car
     * at each location.
     *
     * If the number of passengers exceeds the given capacity
     * at any point, return false.
     *
     * Important:
     * Passengers leave the car at 'end', so we subtract them
     * at arr[end].
     *
     * Time Complexity: O(n + 1000)
     * Space Complexity: O(1000)
     */

    public boolean carPooling(int[][] trips, int capacity) {

        // Difference array for passenger changes
        int[] arr = new int[1001];

        for (int i = 0; i < trips.length; i++) {

            int passenger = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];

            // Passengers enter at start
            arr[start] += passenger;

            // Passengers leave at end
            arr[end] -= passenger;
        }

        int current = 0;

        // Prefix sum gives current passengers
        for (int i = 0; i < arr.length; i++) {

            current += arr[i];

            // Capacity exceeded
            if (current > capacity) {
                return false;
            }
        }

        return true;
    }
}
