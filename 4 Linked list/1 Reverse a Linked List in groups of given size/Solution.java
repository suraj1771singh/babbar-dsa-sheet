class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public static Node reverse(Node node, int k) {
        int n = 0;
        Node p = node;
        while (p != null) {
            p = p.next;
            n++;
        }
        n = n / k;
        Node connector = null;
        Node globalHead = null;
        Node newTail = node;
        Node newHead = null;
        while (n-- > 0) {
            int m = k;
            newTail = node;
            newHead = null;
            while (m-- > 0) {
                Node temp = node.next;
                node.next = newHead;
                newHead = node;
                node = temp;

            }

            if (globalHead == null)
                globalHead = newHead;
            if (connector != null)
                connector.next = newHead;
            connector = newTail;
        }
        newHead = null;
        while (node != null) {
            Node temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        newTail.next = newHead;
        return globalHead;
    }
}
// Time complexity : O(n), 2 passes
// Space complexity : O(1)