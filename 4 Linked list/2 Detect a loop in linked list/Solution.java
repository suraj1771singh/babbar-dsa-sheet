class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// ----------------------FAST AND SLOW POINTER

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        Node fp = head, sp = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (sp == fp)
                return true;
        }
        return false;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)