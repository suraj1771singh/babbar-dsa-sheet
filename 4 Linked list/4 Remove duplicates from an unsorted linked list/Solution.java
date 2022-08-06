import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {

    public Node removeDuplicates(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node p = head;
        set.add(p.data);
        while (p.next != null) {
            if (set.contains(p.next.data))
                p.next = p.next.next;
            else {
                set.add(p.next.data);
                p = p.next;
            }
        }
        return head;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)