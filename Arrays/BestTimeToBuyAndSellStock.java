/*
Problem: Best Time to Buy and Sell Stock
LeetCode: 121
Difficulty: Easy

Approach:
- Keep track of the minimum stock price seen so far.
- Calculate the profit if we sell on the current day.
- Update the maximum profit whenever a better profit is found.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Update minimum buying price
            minPrice = Math.min(minPrice, price);

            // Calculate profit if sold today
            int profit = price - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
