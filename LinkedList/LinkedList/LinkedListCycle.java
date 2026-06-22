/*
Problem: Linked List Cycle
LeetCode: 141
Difficulty: Easy

Approach:
- Use Floyd's Cycle Detection Algorithm.
- Move slow by one step and fast by two steps.
- If they meet, a cycle exists.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
