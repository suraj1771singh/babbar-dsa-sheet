
//-----------------------MERGE SORT ON LINKED LIST
class Node {
    int data;
    Node next;

    Node(int key) {
        this.data = key;
        next = null;
    }
}

class Solution {

    static Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null)
            return head;
        // first find mid;
        Node mid = findMid(head);
        // split into two halfs
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);

        // now merge both two halves;
        Node result = merge(left, right);
        return result;
    }

    static Node findMid(Node head) {
        Node sp = head, fp = head.next;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }

    static Node merge(Node left, Node right) {
        Node head = new Node(-1);
        Node h = head;
        while (left != null && right != null) {
            if (left.data < right.data) {
                Node temp = new Node(left.data);
                h.next = temp;
                h = temp;
                left = left.next;
            } else {
                Node temp = new Node(right.data);
                h.next = temp;
                h = temp;
                right = right.next;
            }
        }
        while (left != null) {
            Node temp = new Node(left.data);
            h.next = temp;
            h = temp;
            left = left.next;
        }
        while (right != null) {
            Node temp = new Node(right.data);
            h.next = temp;
            h = temp;
            right = right.next;
        }
        return head.next;

    }
}
// Time complexity : O(n*log n )
