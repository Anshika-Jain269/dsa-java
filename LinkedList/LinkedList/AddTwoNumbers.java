/*
Problem: Add Two Numbers
LeetCode: 2
Difficulty: Medium

Approach:
- Traverse both lists simultaneously.
- Add corresponding digits and carry.
- Create a new node for each digit.

Time Complexity: O(max(n,m))
Space Complexity: O(max(n,m))

Author: Anshika Jain
*/

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}
