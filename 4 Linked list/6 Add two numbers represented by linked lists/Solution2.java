import java.util.Stack;

//----------------------------EFFICIENT APPROACH (using stack )

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution2 {
    static Node addTwoLists(Node first, Node second) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (first != null) {
            s1.add(first.data);
            first = first.next;
        }
        while (second != null) {
            s2.add(second.data);
            second = second.next;
        }
        int carry = 0;
        Node head=null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum=0;
            if(!s1.isEmpty()) sum+=s1.pop();
            if(!s2.isEmpty()) sum+=s2.pop();
            sum+=carry;
            carry=sum/10;
            Node temp= new Node(sum%10);
            temp.next=head;
            head=temp;
        }
        return head;
    }

}
// Time complexity : O( n) , n is length of larger linked list
// Space complexity : O(n)
