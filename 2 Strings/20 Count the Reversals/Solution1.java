import java.util.*;

//---------USING STACK 
//----ALGO
/*
 * 1) push sting character into stack and pop if  () formed 
 */

class Sol {
    int countRev(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == '(' && c == ')')
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        int n = stack.size();
        int cnt = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '(')
                cnt++;
        }
        if ((n & 1) == 1)
            return -1;
        if ((cnt & 1) == 0)
            return n / 2;
        else
            return n / 2 + 1;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)