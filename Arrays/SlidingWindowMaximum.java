/*
Problem: Sliding Window Maximum
LeetCode: 239
Difficulty: Hard

Approach:
- Use a Deque to store indices.
- Remove smaller elements from back.
- Remove out-of-window elements from front.

Time Complexity: O(n)
Space Complexity: O(k)

Author: Anshika Jain
*/

import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {

                result[index++] =
                        nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
