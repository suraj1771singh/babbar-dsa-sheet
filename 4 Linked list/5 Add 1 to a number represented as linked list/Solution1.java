//-----------------------------NAIVE SOLUTION

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

// ---------ALGO
/*
 * 1) reverse LL
 * 2) add 1 and keep on carry ahead
 * 3) reverse LL and return head;
 */
class Solution1 {
    public static Node addOne(Node head) {
        head = reverse(head);
        Node p = head;
        int carry = 1;
        while (carry != 0 && p.next != null) {
            p.data = p.data + carry;
            if (p.data > 9) {
                p.data = 0;
                carry = 1;
            } else
                carry = 0;
            p = p.next;
        }
        p.data = p.data + carry;
        if (p.data > 9) {
            p.data = 0;
            carry = 1;
        } else
            carry = 0;
        if (carry == 1) {
            Node temp = new Node(1);
            p.next = temp;
        }
        head = reverse(head);
        return head;
    }

    public static Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
// Time complexity : O(n), 3 passes
// Space complexity : O(n)