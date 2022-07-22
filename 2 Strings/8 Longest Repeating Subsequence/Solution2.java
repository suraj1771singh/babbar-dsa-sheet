import java.util.Arrays;

//--------MEOIZATION APPROACH
// Varaition of LCS 
// Hint : take two str (same) and find LCS such that i!=j

class Solution2 {
    public int LongestRepeatingSubsequence(String str) {
        int n = str.length();
        int dp[][] = new int[n + 1][n + 1];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(n - 1, n - 1, str, dp);
    }

    public int f(int i, int j, String s, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i != j && s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 1 + f(i - 1, j - 1, s, dp);
        }
        return dp[i][j] = Math.max(f(i - 1, j, s, dp), f(i, j - 1, s, dp));
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)+ O(n)