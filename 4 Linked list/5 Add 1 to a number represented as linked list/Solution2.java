//--------------------------USING RECURSION
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Solution2 {
    public static Node addOne(Node head) {
        head = f(head);
        if (head.data > 9) {
            Node temp = new Node(1);
            head.data = 0;
            temp.next = head;
            head = temp;
        }
        return head;

    }

    public static Node f(Node head) {
        if (head.next == null) {
            head.data += 1;
            return head;
        }
        Node temp = f(head.next);
        if (temp.data > 9) {
            head.data += 1;
            temp.data = 0;
        }

        return head;
    }
}
// Time complexity : O(n)
// Space complexity : O(1), AS : O(n)