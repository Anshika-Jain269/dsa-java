/*
 * Problem: LeetCode 412 - Fizz Buzz
 *
 * Approach:
 * 1. Traverse numbers from 1 to n.
 * 2. If a number is divisible by both 3 and 5, add "FizzBuzz".
 * 3. If divisible by 3 only, add "Fizz".
 * 4. If divisible by 5 only, add "Buzz".
 * 5. Otherwise, add the number as a String.
 * 6. Return the resulting list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        // Check every number from 1 to n
        for (int i = 1; i <= n; i++) {

            // Check divisibility by both 3 and 5 first
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                // Convert the number into a String
                answer.add(String.valueOf(i));
            }
        }

        return answer;
    }
}
