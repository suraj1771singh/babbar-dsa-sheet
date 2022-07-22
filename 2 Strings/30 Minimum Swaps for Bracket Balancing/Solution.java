//------------EFFICIENT SOLUTION
class Solution {
    static int minimumNumberOfSwaps(String s) {
        int ans = 0, open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                open++;
            else {
                open--;
                if (open < 0)
                    ans += open * -1;
            }
        }
        return ans;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)