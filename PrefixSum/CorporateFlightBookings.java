class Solution {

    /*
     * Problem: Corporate Flight Bookings
     *
     * Approach:
     * We use a Difference Array to efficiently apply
     * multiple range updates.
     *
     * For each booking:
     *
     * [start, end, seats]
     *
     * We add 'seats' at the starting flight and subtract
     * 'seats' after the ending flight.
     *
     * Since the array uses 0-based indexing:
     *
     * arr[start - 1] += seats;
     * arr[end] -= seats;   // Only if end < n
     *
     * After processing all bookings, we calculate the
     * prefix sum to get the actual number of seats booked
     * for each flight.
     *
     * Time Complexity: O(bookings.length + n)
     * Space Complexity: O(n)
     */

    public int[] corpFlightBookings(int[][] bookings, int n) {

        // Difference array
        int[] arr = new int[n];

        // Apply all range updates
        for (int i = 0; i < bookings.length; i++) {

            int start = bookings[i][0];
            int end = bookings[i][1];
            int seats = bookings[i][2];

            // Add seats starting from start
            arr[start - 1] += seats;

            // Remove seats after the ending flight
            if (end < n) {
                arr[end] -= seats;
            }
        }

        // Convert difference array into the final result
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            arr[i] = sum;
        }

        return arr;
    }
}
