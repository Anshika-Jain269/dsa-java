import java.util.ArrayList;
import java.util.List;

class Solution {

    // LeetCode 131 - Palindrome Partitioning
    // Approach: Backtracking + Palindrome Checking
    // Time Complexity: O(N × 2^N)
    // Space Complexity: O(N) recursion stack (excluding output)

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(0, s, new ArrayList<>(), result);

        return result;
    }

    // Recursively builds all possible palindrome partitions
    private void backtrack(int start, String s,
                           List<String> path,
                           List<List<String>> result) {

        // Base Case:
        // If we have reached the end of the string,
        // store the current partition.
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring starting from 'start'
        for (int end = start; end < s.length(); end++) {

            // Proceed only if the current substring is a palindrome
            if (isPalindrome(s, start, end)) {

                // Choose the current palindrome substring
                path.add(s.substring(start, end + 1));

                // Explore the remaining string
                backtrack(end + 1, s, path, result);

                // Backtrack: remove the last chosen substring
                path.remove(path.size() - 1);
            }
        }
    }

    // Checks whether substring s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
