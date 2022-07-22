
//---------simple NAIVE APPROACH

class Solution1 {
    int isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return 0;
        return 1;
    }
};
// Time complexity : O(n)
// Spac complexity : O(1)