/*
Problem: Middle of the Linked List
LeetCode: 876
Difficulty: Easy

Approach:
- Use slow and fast pointers.
- Slow moves one step.
- Fast moves two steps.
- When fast reaches the end, slow will be at the middle.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
