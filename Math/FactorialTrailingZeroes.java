class Solution {

    /*
     * Approach:
     * A trailing zero is produced by a factor of 10.
     * Since 10 = 2 * 5, we need pairs of 2 and 5.
     * In factorials, there are always more factors of 2 than 5.
     * Therefore, the number of trailing zeroes depends on the
     * number of factors of 5.
     *
     * We repeatedly divide n by 5 to count:
     * - Multiples of 5       -> contribute at least one 5
     * - Multiples of 25      -> contribute an additional 5
     * - Multiples of 125     -> contribute another 5
     *
     * Example:
     * n = 25
     * 25 / 5 = 5
     * 25 / 25 = 1
     * Total = 6 trailing zeroes
     *
     * Time Complexity: O(log₅ n)
     * Space Complexity: O(1)
     */

    public int trailingZeroes(int n) {

        if (n == 0) return 0;

        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }

        return count;
    }
}
