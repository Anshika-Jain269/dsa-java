/*
Problem: Reverse Linked List II
LeetCode: 92
Difficulty: Medium

Approach:
- Reach the left position.
- Reverse nodes from left to right.
- Connect the reversed part back to the list.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}
