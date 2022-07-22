//-------NAIVE APPROACH
//-------ALGO
/*
 1) THere are two alternate pattern
     1010101...
     01010101....
     look of them and return mini of them
*/
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        // case 1 : pattern 01
        int cnt1 = 0;
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != '0')
                cnt1++;
            if (i + 1 < n && s.charAt(i + 1) != '1')
                cnt1++;
        }

        // case 2 : pattern 10
        int cnt2 = 0;
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != '1')
                cnt2++;
            if (i + 1 < n && s.charAt(i + 1) != '0')
                cnt2++;
        }

        return Math.min(cnt1, cnt2);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)