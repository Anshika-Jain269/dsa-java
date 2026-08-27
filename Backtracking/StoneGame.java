class Solution {

    // Approach: Recursion / Game Strategy
    // At every turn, the player has two choices:
    // take the left pile or take the right pile.
    // The solve() method calculates the maximum score difference
    // the current player can achieve.

    public boolean stoneGame(int[] piles) {
        // Stone Game I always has an even number of piles,
        // so Alice can always win with optimal play.
        return true;
    }

    // Recursive approach used for understanding the problem
    public int solve(int[] piles, int left, int right) {

        // Base case: only one pile remains
        if (left == right) {
            return piles[left];
        }

        // Choice 1: take the left pile
        int leftChoice =
            piles[left] - solve(piles, left + 1, right);

        // Choice 2: take the right pile
        int rightChoice =
            piles[right] - solve(piles, left, right - 1);

        // Choose the better score difference
        return Math.max(leftChoice, rightChoice);
    }
}
