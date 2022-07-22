import java.util.Arrays;

//----------MEMOIZATION

class Solution2 {
    private static final int MOD = (int) Math.pow(10, 9) + 7;

    long countPS(String str) {
        int n = str.length();
        long dp[][] = new long[n][n];
        for (long[] r : dp)
            Arrays.fill(r, -1);
        return f(0, n - 1, str, dp);
    }

    long f(int i, int j, String s, long[][] dp) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = (1 + f(i, j - 1, s, dp) + f(i + 1, j, s, dp)) % MOD;
        else
            return dp[i][j] = (MOD + f(i, j - 1, s, dp) + f(i + 1, j, s, dp) - f(i + 1, j - 1, s, dp)) % MOD;
    }

}
// Time complexity : O(s^2)
// Space complexity : O(s^2)+O(s)