class Solution {

    /*
     * Approach:
     * We use Binary Search on the answer.
     *
     * The minimum possible capacity is the maximum weight because
     * every package must be shipped without splitting it.
     *
     * The maximum possible capacity is the sum of all weights,
     * because we can ship all packages in one day.
     *
     * For each possible capacity (mid), we calculate how many days
     * are required to ship all packages.
     *
     * If daysNeeded <= days:
     *     The capacity is sufficient, so we try a smaller capacity.
     *
     * If daysNeeded > days:
     *     The capacity is too small, so we increase it.
     *
     * Time Complexity: O(n * log(sum(weights)))
     * Space Complexity: O(1)
     */

    public int shipWithinDays(int[] weights, int days) {

        // Minimum capacity = maximum individual package weight
        int left = 0;

        // Maximum capacity = sum of all package weights
        int right = 0;

        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
            left = Math.max(left, weights[i]);
        }

        // Binary search for the minimum valid capacity
        while (left < right) {

            int mid = (left + right) / 2;

            int daysNeeded = 1;
            int currentWeight = 0;

            // Calculate the number of days needed
            // with capacity = mid
            for (int weight : weights) {

                if (currentWeight + weight > mid) {

                    // Start shipping on the next day
                    daysNeeded++;
                    currentWeight = weight;
                } 
                else {
                    currentWeight += weight;
                }
            }

            // Capacity is sufficient, try a smaller capacity
            if (daysNeeded <= days) {
                right = mid;
            } 
            else {
                // Capacity is insufficient, increase it
                left = mid + 1;
            }
        }

        // left is the minimum capacity that works
        return left;
    }
}
