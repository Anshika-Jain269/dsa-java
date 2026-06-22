/*
Problem: Remove Cycle in Linked List
Difficulty: Medium

Approach:
- Detect the cycle using slow and fast pointers.
- Move one pointer to the head.
- Find the starting node of the cycle.
- Remove the cycle by setting the previous node's next to null.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public static void removeCycle(Node head) {

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return;
        }

        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }
}
