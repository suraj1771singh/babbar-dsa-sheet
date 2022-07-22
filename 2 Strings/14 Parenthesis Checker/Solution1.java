import java.util.Stack;

//------------USING STACK 

class Solution1 {

    static boolean ispar(String x) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']'))
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// Time complexity : O(n)
// Spac complexity : O(n)