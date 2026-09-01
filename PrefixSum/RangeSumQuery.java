class NumArray {

    int[] prefix;

    /*
     * Approach:
     * We use the Prefix Sum technique.
     *
     * prefix[i] stores the sum of the first i elements.
     *
     * Example:
     * nums   = [1, 2, 3, 4]
     * prefix = [0, 1, 3, 6, 10]
     *
     * The extra 0 at the beginning makes it easier to calculate
     * the sum of any range.
     *
     * To find the sum from left to right:
     *
     * prefix[right + 1] - prefix[left]
     *
     * This removes the sum of all elements before 'left'.
     *
     * Time Complexity:
     * Constructor -> O(n)
     * sumRange()  -> O(1)
     *
     * Space Complexity: O(n)
     */

    public NumArray(int[] nums) {

        // Create prefix array with one extra space
        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {

            // Build prefix sum array
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        // Range sum = prefix[right + 1] - prefix[left]
        return prefix[right + 1] - prefix[left];
    }
}

/*
 * Your NumArray object will be instantiated and called as such:
 *
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left, right);
 */
