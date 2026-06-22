/*
Problem: Merge Two Sorted Lists
LeetCode: 21
Difficulty: Easy

Approach:
- Use a dummy node.
- Compare nodes from both lists.
- Attach the smaller node to the result list.

Time Complexity: O(n + m)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        }

        if (list2 != null) {
            curr.next = list2;
        }

        return dummy.next;
    }
}
