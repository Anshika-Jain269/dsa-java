class Solution {

    /*
     * Problem: Best Time to Buy and Sell Stock III
     *
     * Approach:
     * We use Dynamic Programming with four states:
     *
     * buy1  -> Maximum profit after the first buy
     * sell1 -> Maximum profit after the first sell
     * buy2  -> Maximum profit after the second buy
     * sell2 -> Maximum profit after the second sell
     *
     * State transitions:
     *
     * buy1  = max(buy1, -price)
     * sell1 = max(sell1, buy1 + price)
     * buy2  = max(buy2, sell1 - price)
     * sell2 = max(sell2, buy2 + price)
     *
     * We update the states for every price and finally
     * return sell2, which represents the maximum profit
     * after at most two transactions.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public int maxProfit(int[] prices) {

        // Maximum profit after first buy
        int buy1 = Integer.MIN_VALUE;

        // Maximum profit after second buy
        int buy2 = Integer.MIN_VALUE;

        // Maximum profit after first sell
        int sell1 = 0;

        // Maximum profit after second sell
        int sell2 = 0;

        for (int i = 0; i < prices.length; i++) {

            // Buy stock for the first time
            buy1 = Math.max(buy1, -prices[i]);

            // Sell stock for the first time
            sell1 = Math.max(sell1, buy1 + prices[i]);

            // Buy stock for the second time
            buy2 = Math.max(buy2, sell1 - prices[i]);

            // Sell stock for the second time
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
