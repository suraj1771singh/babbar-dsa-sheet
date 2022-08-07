//------------------NAIVE APPROACH

//-------ALGO
/*
 * 1) reverse both LL
 * 2) add them with carry
 * 3) reverse the resultant linked list
 */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    static Node addTwoLists(Node first, Node second) {
        Node head = new Node(0);
        Node h = head;
        first = reverse(first);
        second = reverse(second);
        int carry = 0;
        while (first != null || second != null || carry != 0) {
            int sum = 0;
            if (first != null) {
                sum += first.data;
                first = first.next;
            }

            if (second != null) {

                sum += second.data;
                second = second.next;
            }
            sum += carry;
            Node temp = new Node(sum % 10);
            carry = sum / 10;
            h.next = temp;
            h = temp;

        }
        return reverse(head.next);
    }

    static Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
// Time complexity : O( max(m,n) ), 3 passes
// Space complexity : O(1)