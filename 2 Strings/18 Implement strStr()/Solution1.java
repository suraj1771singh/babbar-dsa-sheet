//-------NAIVE APPROACH

//---ALGO
/*
 * 1) Take a window of length m in haystack and keep searching in it .
 */
class Solution1 {
    public int strStr(String haystack, String needle) {
        int m = needle.length(), n = haystack.length();
        for (int i = 0; i <= n - m; i++)
            if (needle.equals(haystack.substring(i, i + m)))
                return i;
        return -1;
    }
}
// Time complexity : O((n-m)*m)
// Space complexity : O(1)