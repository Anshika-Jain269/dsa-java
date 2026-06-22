/*
Problem: String Compression
LeetCode: 443
Difficulty: Medium

Approach:
- Use two pointers.
- Traverse the array and count consecutive occurrences of each character.
- Write the character once, followed by its frequency if the count is greater than 1.
- Return the length of the compressed array.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public int compress(char[] chars) {

        int i = 0;
        int index = 0;

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            chars[index++] = current;

            if (count > 1) {
                String str = Integer.toString(count);

                for (char ch : str.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }
}
