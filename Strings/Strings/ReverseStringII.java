/*
 * Problem: LeetCode 541 - Reverse String II
 *
 * Approach:
 * 1. Convert the string into a StringBuilder.
 * 2. Traverse the string in steps of 2 * k.
 * 3. Reverse the first k characters of each 2 * k block.
 * 4. If fewer than k characters remain, reverse all of them.
 * 5. Return the modified string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        // Process each block of 2 * k characters
        for (int i = 0; i < sb.length(); i += 2 * k) {
            int left = i;

            // Ensure the right pointer stays within the string
            int right = Math.min(i + k - 1, sb.length() - 1);

            // Reverse the first k characters of the current block
            while (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);

                left++;
                right--;
            }
        }

        return sb.toString();
    }
}
