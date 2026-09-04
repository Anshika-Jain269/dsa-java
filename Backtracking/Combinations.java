import java.util.ArrayList;
import java.util.List;

class Solution {

    /*
     * Problem: Combinations
     *
     * Approach:
     * We use Recursion + Backtracking.
     *
     * We generate all possible combinations of k numbers
     * chosen from the range [1, n].
     *
     * At each step:
     * 1. Choose a number.
     * 2. Recursively explore the remaining numbers.
     * 3. Undo the choice (backtrack) and try the next number.
     *
     * We start the next recursive call with i + 1 so that:
     * - The same number is not selected again.
     * - Combinations are generated without duplicates.
     *
     * Base Case:
     * When current.size() == k, we have a complete combination,
     * so we add a copy of current to the result.
     *
     * Time Complexity: O(C(n, k) * k)
     * Space Complexity: O(k)
     *   - Recursion stack + current combination
     *   - Output space is not included
     */

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // Start generating combinations from number 1
        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int start, int n, int k,
                          List<Integer> current,
                          List<List<Integer>> result) {

        // Base case: combination of size k is complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible number from start to n
        for (int i = start; i <= n; i++) {

            current.add(i);                         // Choose

            backtrack(i + 1, n, k, current, result); // Explore

            current.remove(current.size() - 1);     // Undo
        }
    }
}
