class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        // Smallest possible divisor is 1
        int left = 1;

        // Largest possible divisor is the maximum element
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Binary search for the smallest valid divisor
        while (left < right) {

            int mid = (left + right) / 2;

            // Calculate the sum of rounded-up divisions
            int sum = 0;

            for (int num : nums) {

                // Ceiling division:
                // ceil(num / mid) = (num + mid - 1) / mid
                sum += (num + mid - 1) / mid;
            }

            // If the sum is within the threshold,
            // mid can be a possible answer
            if (sum <= threshold) {
                right = mid;
            }

            // If the sum exceeds the threshold,
            // divisor is too small, so increase it
            else {
                left = mid + 1;
            }
        }

        // left is the smallest divisor that satisfies the condition
        return left;
    }
}
