/*
Problem: Flattening a Linked List
Difficulty: Hard

Approach:
- Recursively flatten the right side.
- Merge two sorted linked lists using bottom pointers.

Time Complexity: O(N * M)
Space Complexity: O(N) (recursion stack)

Author: Anshika Jain
*/

class Solution {

    Node merge(Node a, Node b) {

        Node dummy = new Node(0);
        Node curr = dummy;

        while (a != null && b != null) {

            if (a.data < b.data) {
                curr.bottom = a;
                a = a.bottom;
            } else {
                curr.bottom = b;
                b = b.bottom;
            }

            curr = curr.bottom;
        }

        if (a != null) {
            curr.bottom = a;
        }

        if (b != null) {
            curr.bottom = b;
        }

        return dummy.bottom;
    }

    Node flatten(Node root) {

        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);

        root = merge(root, root.next);

        return root;
    }
}
