import java.util.Arrays;

//------------MEMOIZATION

class Solution2 {
    public int editDistance(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int dp[][] = new int[l1][l2];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(l1 - 1, l2 - 1, s, t, dp);
    }

    public int f(int i, int j, String s, String t, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j))
            return dp[i][j] = f(i - 1, j - 1, s, t, dp);

        // insert
        int insert = f(i, j - 1, s, t, dp);
        // replace
        int replace = f(i - 1, j - 1, s, t, dp);
        // remove
        int remove = f(i - 1, j, s, t, dp);
        // return max of them
        return dp[i][j] = 1 + Math.min(insert, Math.min(replace, remove));

    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2) +(n)