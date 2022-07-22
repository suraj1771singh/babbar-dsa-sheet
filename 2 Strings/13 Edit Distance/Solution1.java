
//------------RECURSIVE APPROACH

class Solution1 {
    public int editDistance(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        return f(l1 - 1, l2 - 1, s, t);
    }

    public int f(int i, int j, String s, String t) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (s.charAt(i) != t.charAt(j))
            return f(i - 1, j - 1, s, t);
        // insert
        int insert = f(i, j - 1, s, t);
        // replace
        int replace = f(i - 1, j - 1, s, t);
        // remove
        int remove = f(i - 1, j, s, t);
        // return max of them
        return 1 + Math.min(insert, Math.min(replace, remove));

    }
}
// Time complexity : O(4^n)
// Space complexity : O(n)