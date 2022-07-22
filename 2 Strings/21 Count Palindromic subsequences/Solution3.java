import java.util.Set;


//-----------TABULATION DP

public class Solution3 {

    private static final long MOD = (long) Math.pow(10, 9) + 7;

    long countPS(String str) {
        int n = str.length();
        long dp[][] = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int g = 1; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] + 1) % MOD;
                else
                    dp[i][j] = (MOD + dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]) % MOD;
            }
        }
        return dp[0][n - 1];
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)
