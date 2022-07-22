
//--------RECURSIVE APPROACH
// Varaition of LCS 
// Hint : take two str (same) and find LCS such that i!=j

class Solution1 {
    public int LongestRepeatingSubsequence(String str) {
        int n = str.length();
        return f(n - 1, n - 1, str);
    }

    public int f(int i, int j, String s) {
        if (i < 0 || j < 0)
            return 0;
        if (i != j && s.charAt(i) == s.charAt(j)) {
            return 1 + f(i - 1, j - 1, s);
        }
        return Math.max(f(i - 1, j, s), f(i, j - 1, s));
    }
}