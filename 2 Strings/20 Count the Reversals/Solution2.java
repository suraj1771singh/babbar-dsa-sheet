//-------SPACE OPTIMZED 
//--------ALGO
/*
 * 1) instead of using  stack we can keep track of '('  character(lets say cnt1=0)
 * 2) on traversing string 
 *     if s[i]=='('=>cnt1++;
 *     else if (s[i]=='(' && cnt>0) => cnt1--;
 *     else cnt2++;
 * 3) cnt2 is to counter of ')', which is imbalance
 * 4) ans is possible if cnt1+cnt2 is even  
 */

public class Solution2 {
    int countRev(String s) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                cnt1++;
            else if (c == ')' && cnt1 > 0)
                cnt1--;
            else
                cnt2++;
        }
        if ((cnt1 + cnt2) % 2 == 0) {
            // even
            if (cnt1 % 2 == 0)
                return (cnt1 + cnt2) / 2;
            // odd
            else
                return (cnt1 + cnt2) / 2 + 1;
        } else
            return -1;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)
