/*
Problem: Reverse Linked List
LeetCode: 206
Difficulty: Easy

Approach:
- Use three pointers:
  1. prev
  2. curr
  3. next
- Reverse the links one by one.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
