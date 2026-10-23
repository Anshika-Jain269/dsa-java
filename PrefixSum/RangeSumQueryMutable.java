/*
 * Problem: LeetCode 307 - Range Sum Query - Mutable
 *
 * Approach:
 * 1. Use a Fenwick Tree (Binary Indexed Tree) to maintain prefix sums.
 * 2. Build the tree by adding each array element.
 * 3. For an update, calculate the difference between the new
 *    and old values, then update the Fenwick Tree.
 * 4. Calculate sumRange(left, right) using prefix sums:
 *    prefixSum(right) - prefixSum(left - 1).
 *
 * Time Complexity:
 * Constructor: O(n log n)
 * Update: O(log n)
 * Sum Range: O(log n)
 *
 * Space Complexity: O(n)
 */

class NumArray {
    int[] nums;
    int[] bit;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums.clone();
        n = nums.length;
        bit = new int[n + 1];

        // Build the Fenwick Tree
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        }
    }

    // Add a value to the Fenwick Tree
    private void add(int index, int value) {
        index++;

        while (index <= n) {
            bit[index] += value;

            // Move to the next responsible Fenwick Tree node
            index += index & -index;
        }
    }

    // Calculate the prefix sum from index 0 to index
    private int prefixSum(int index) {
        int sum = 0;
        index++;

        while (index > 0) {
            sum += bit[index];

            // Move to the parent Fenwick Tree node
            index -= index & -index;
        }

        return sum;
    }

    public void update(int index, int val) {
        // Calculate the difference between new and old values
        int diff = val - nums[index];
        nums[index] = val;

        // Update the Fenwick Tree
        add(index, diff);
    }

    public int sumRange(int left, int right) {
        // Return the sum from index 0 to right
        if (left == 0) {
            return prefixSum(right);
        }

        // Subtract the prefix before left
        return prefixSum(right) - prefixSum(left - 1);
    }
}
