//---------------------NAIVE APPROACH

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution1 {

    void splitList(circular_LinkedList lists) {
        Node list = lists.head;
        Node head = list;
        // break circular linked list
        while (list.next != head) {
            list = list.next;
        }
        list.next = null;

        // find mid point of linear LL
        Node sp = head, fp = head.next;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        Node mid = sp;
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // convert right LL to circular LL
        list.next = right;

        // convert left LL to circular LL
        Node p = left;
        while (p.next != null)
            p = p.next;
        p.next = left;

        lists.head1 = left;
        lists.head2 = right;

    }
}
// Time complexity : O(n)