
class Node {
    int data;
    Node next;
}

// ----------------Algo
/*
 * 1) first detect the position of loop
 * 2) then cut it
 */

class Solution {

    public static void removeLoop(Node head) {
        Node sp = head, fp = head, temp = head;
        while (fp != null && fp.next != null) {
            temp = sp;
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                fp = head;
                while (sp != fp) {
                    temp = sp;
                    sp = sp.next;
                    fp = fp.next;

                }
                temp.next = null;
            }
        }

    }
}
// Time complexity : O(n)
// Space complexity : O(1)