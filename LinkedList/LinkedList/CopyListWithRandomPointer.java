/*
Problem: Copy List with Random Pointer
LeetCode: 138
Difficulty: Medium

Approach:
- Insert copied nodes between original nodes.
- Assign random pointers to copied nodes.
- Separate the original and copied lists.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Anshika Jain
*/

class Solution {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node curr = head;

        // Step 1: Insert copy nodes
        while (curr != null) {

            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // Step 2: Set random pointers
        curr = head;

        while (curr != null) {

            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }
}
