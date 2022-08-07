
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        Node head = new Node(0);
        Node h = head;
        while (head1 != null && head2 != null) {
            if (head1.data > head2.data)
                head2 = head2.next;
            else if (head1.data < head2.data)
                head1 = head1.next;
            else {
                Node temp = new Node(head1.data);
                h.next = temp;
                h = temp;
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return head.next;
    }
}
// Time complexity : O(n), n is length of largest LL
// Space complexity : O(1)